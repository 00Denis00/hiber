package com.denis.hibernate.repository.hibernate;

import com.denis.hibernate.model.Post;
import com.denis.hibernate.repository.PostRepository;
import com.denis.hibernate.utils.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HibernatePostRepositoryImpl implements PostRepository
{
    public Post findById(Integer id)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Post post = session.get(Post.class, id);
            post.getTags().size();
            return post;
        }
    }

    public Post save(Post post)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.save(post);
            tx1.commit();
            return findById(post.getId());
        }
    }

    public Post update(Post post)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            Post result = session.get(Post.class, post.getId());
            result.setContent(post.getContent());
            session.update(result);
            tx1.commit();
            return findById(post.getId());
        }
    }

    public void delete(Post post)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.delete(post);
            tx1.commit();
        }
    }

    public List<Post> findAll()
    {
        try (Session session = HibernateUtilities.getSession())
        {
            List<Post> posts = session.createQuery("from Post").list();
            for(int i = 0; i < posts.size(); i++)
            {
                Post post = posts.get(i);
                post.getTags().size();
            }
            return posts;
        }
    }
}
