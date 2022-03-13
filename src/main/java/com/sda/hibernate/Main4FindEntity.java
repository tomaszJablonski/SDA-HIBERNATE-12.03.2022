package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4FindEntity {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //wyciąganie z bazy danych często w Stringu find -- W pracy tylko to najczęściej
        Dog dog1 = session.find(Dog.class, 1L); //select
        if (dog1 != null) {
            System.out.println(dog1.getId());
            System.out.println(dog1.getName());
        }

        System.out.println("---------------------");
        //wyciąganie z bazy danych
        Dog dog2 = session.get(Dog.class, 1L); //select
        if (dog2 != null) {
            System.out.println(dog2.getId());
            System.out.println(dog2.getName());
        }
        System.out.println("----------------------");
        //tutaj tworzy swój własny obiekt
        Dog dog3 = session.load(Dog.class, 1L);
        if (dog3 != null) {
            System.out.println(dog3.getId());
            System.out.println(dog3.getName()); //select
        }

        transaction.commit();
        session.close();
    }
}

