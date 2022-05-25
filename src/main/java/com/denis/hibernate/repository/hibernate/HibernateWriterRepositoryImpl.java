package com.denis.hibernate.repository.hibernate;

import com.denis.hibernate.controller.PostController;
import com.denis.hibernate.model.Post;
import com.denis.hibernate.model.Writer;
import com.denis.hibernate.repository.WriterRepository;
import com.denis.hibernate.utils.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HibernateWriterRepositoryImpl implements WriterRepository
{
    public Writer findById(Integer id)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            return session.get(Writer.class, id);
        }
    }

    public Writer save(Writer writer)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.save(writer);
            tx1.commit();
            return findById(writer.getId());
        }
    }

    public Writer update(Writer writer)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            Writer result = session.get(Writer.class, writer.getId());
            result.setName(writer.getName());
            session.update(result);
            tx1.commit();
            return findById(writer.getId());
        }
    }

    public void delete(Writer writer)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            int id = writer.getId();
            Writer result = session.get(Writer.class, id);
            List<Post> posts = result.getPosts();

            Transaction tx1 = session.beginTransaction();
            for(int i = 0; i < posts.size(); i++)
            {
                Post post = posts.get(i);
                session.delete(post);
            }
            tx1.commit();

            Transaction tx2 = session.beginTransaction();
            session.delete(result);
            tx2.commit();
        }
    }

    public List<Writer> findAll()
    {
        try (Session session = HibernateUtilities.getSession())
        {
            return session.createQuery("from Writer").list();
        }
    }
}
