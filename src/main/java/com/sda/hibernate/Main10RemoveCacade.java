package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main10RemoveCacade {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = session.find(Husband.class,17L);
        if(husband != null){
            session.remove(husband); // usunięcie kaskadowe żony i męża razem
        }


        transaction.commit();
        session.close();
    }

}
