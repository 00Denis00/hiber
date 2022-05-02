import model.Developer;
import model.HibernateUtilities;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperCommander
{
    public Developer findById(int id)
    {
        return HibernateUtilities.getSessionFactory().openSession().get(Developer.class, id);
    }

    public void save(Developer developer)
    {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(developer);
        tx1.commit();
        session.close();
    }

    public void update(Developer developer)
    {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(developer);
        tx1.commit();
        session.close();
    }

    public void delete(Developer developer)
    {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(developer);
        tx1.commit();
        session.close();
    }

    public List<Developer> findAll()
    {
        List<Developer> developers = (List<Developer>) HibernateUtilities.getSessionFactory().openSession().createQuery("from developers").list();
        return developers;
    }
}
