package util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.*;


public class HibernateUtil {

    static SessionFactory factory = null;

    static {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        // Se registran las clases que hay que MAPEAR con cada tabla de la base de datos

        cfg.addAnnotatedClass(Group.class);
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(UserGroup.class);



        factory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }


    public static Session getSession() {
        return factory.openSession();
    }




}
