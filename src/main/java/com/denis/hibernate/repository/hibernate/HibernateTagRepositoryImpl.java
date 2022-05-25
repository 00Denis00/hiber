package com.denis.hibernate.repository.hibernate;

import com.denis.hibernate.model.Tag;
import com.denis.hibernate.repository.TagRepository;
import com.denis.hibernate.utils.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateTagRepositoryImpl implements TagRepository
{
    public Tag findById(Integer id)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            return session.get(Tag.class, id);
        }
    }

    public Tag save(Tag tag)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.save(tag);
            tx1.commit();
            return tag;
        }
    }

    public Tag update(Tag tag)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.update(tag);
            tx1.commit();
            return tag;
        }
    }

    public void delete(Tag tag)
    {
        try (Session session = HibernateUtilities.getSession())
        {
            Transaction tx1 = session.beginTransaction();
            session.delete(tag);
            tx1.commit();
        }
    }

    public List<Tag> findAll()
    {
        try (Session session = HibernateUtilities.getSession())
        {
            return session.createQuery("from Tag").list();
        }
    }
}
