package com.sda.hibernate;

/*
Obiekty
    Nie posiada pola @id
    Musi posiadać bezargumentowy konstruktor
    Nie podajemy
    @Embeded - dodatkowa klasa z której kożystamy w głównym Entity
    @Embeddable - używana klasa osobna

    działa tu mechanizm dirty checking

 */

import com.sda.hibernate.entityInfoBardzoWazne.Address;
import com.sda.hibernate.entityInfoBardzoWazne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main8Embedded {
    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Address address = new Address("Gdańsk","Aleja Grunwaldzka");

        Date date = new SimpleDateFormat("dd/mm/yyyy").parse("31/12/1990");
        Employee employee = new Employee("Jan", "password", "123456789", 20L, date, Employee.Gender.MALE, "description");
        employee.setAddress(address);
        address.setStreet("Chopina");
        session.persist(employee);


        transaction.commit();
        session.close();

    }
}
