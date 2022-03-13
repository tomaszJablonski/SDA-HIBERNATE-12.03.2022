package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Husband;
import com.sda.hibernate.entityInfoBardzoWazne.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main9OneToOne {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = new Husband("Adam");
        Wife wife = new Wife("Ewa");

        session.persist(husband);
        session.persist(wife);

        wife.setHusband(husband);

        System.out.println("-------------");


        session.persist(new Husband("Michał",new Wife("Katarzyna")));
        session.persist(new Husband("Michał",new Wife("Katarzyna")));
        session.persist(new Husband("Michał",new Wife("Katarzyna")));
        session.persist(new Husband("Michał",new Wife("Katarzyna")));


        transaction.commit();
        session.close();
    }
}
