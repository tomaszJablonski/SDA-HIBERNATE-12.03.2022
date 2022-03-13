package com.sda.hibernate;

import com.sda.hibernate.entityInfoBardzoWazne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//hbm2ddl.auto: validate, update, create, create-drop, create-only, drop, none

public class Main7Annotation {
    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Date date = new SimpleDateFormat("dd/mm/yyyy").parse("31/12/1990");
        new Employee("Jan", "password", "123456789", 20L, date, Employee.Gender.MALE, "description");

        transaction.commit();
        session.close();
    }
}
