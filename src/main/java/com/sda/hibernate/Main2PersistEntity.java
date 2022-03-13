package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
    TRANSAKCJE !!!!!!!!!!!
    MUST HAVE

    Transient i Detached - dane nie są śledzone przez Hibernate
    Persistent - dane są śledzone

 */

public class Main2PersistEntity {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //tak dodajemy rekordy w Java do Bazy Danych sql
        //w sql tak:
        //INSERT INTO dog (name,age,race) VALUES('Ares',10,'Terier')
        session.persist(new Dog("Ares", 10, "Terier"));
        session.persist(new Dog("Sonia", 5, "Buldog"));
        session.persist(new Dog("Reksio", 6, "Doberman"));
        session.persist(new Dog("Benio", 12, "Jamnik"));
        session.persist(new Dog("Aza", 4, "Wilczur"));



        transaction.commit();
        session.close();
    }
}
