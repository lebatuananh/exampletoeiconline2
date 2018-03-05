package vn.mra.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by tuana on 2/27/2018.
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory=buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try {
            //create sessionfactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            System.err.print("Initial session factory failed");
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory(){
    return sessionFactory;
    }
}
