package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

public class Main6DeleteEntity {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //bezpieczniejsza jest ta pierwsza opcja - tą wykorzystywać
        Dog dog1 = session.find(Dog.class, 3L);
        if (dog1 != null) {
            session.delete(dog1);
        }


        try {
            Dog dog2 = new Dog();
            dog2.setId(4L);
            session.delete(dog2);
            transaction.commit();
        }catch (OptimisticLockException e){
            System.out.println("Krotka o podanym id nie istnieje w bazie " + 4L);
        }
        session.close();

    }
}
