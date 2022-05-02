import model.Developer;
import model.HibernateUtilities;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.List;

public class DeveloperRunner
{
    public static void main(String[] args)
    {
        DeveloperCommander developerCommander = new DeveloperCommander();
        Developer developer = new Developer("Masha","Maidanyuk", "C++", 5);
        developerCommander.save(developer);
        List<Developer> developers = developerCommander.findAll();
        for(int i = 0; i < developers.size(); i++)
        {
            Developer show = developers.get(i);
            String result = show.toString();
            System.out.println(result);
        }
    }
}