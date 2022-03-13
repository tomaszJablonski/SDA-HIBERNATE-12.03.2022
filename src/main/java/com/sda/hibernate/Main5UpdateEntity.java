package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //modyfikowanie danych - Update

        Dog dog1 = new Dog(); // id=null, name = null, age = null, race = null
        dog1.setId(1L);       // id=1, name = null, age = null, race = null
        dog1.setAge(15);      // id=1, name = null, age = 15, race = null
        dog1.setName("Kora"); // id=1, name = kora, age = 15, race = null
        dog1.setRace("York"); // id=1, name = kora, age = 15, race = York
        session.update(dog1); // id=1, name = kora, age = 15, race = York

        System.out.println("-----------------------");

        //W pracy tylko tak !!!!!
        Dog dog2 = session.find(Dog.class, 2L);
        dog2.setAge(1);

        //usuwanie danych


        transaction.commit();
        session.close();
    }
}
