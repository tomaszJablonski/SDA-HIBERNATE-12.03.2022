package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3PeristExample {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Azor", 10, "Husky");

        System.out.println("id " + dog.getId());
        session.persist(dog); //INSERT INTO dog (name,age,race) VALUES (?,?,?)
        System.out.println("id " + dog.getId());

        dog.setAge(11);
        //session.evict(dog); // odłącza obiekt dog od obiektu persystencji czyli nie wykona się commit

        dog.setRace("Chihuahua");

        transaction.commit(); // update sog set age=?, name=?,race=? where id=?
        session.close();


    }
}
