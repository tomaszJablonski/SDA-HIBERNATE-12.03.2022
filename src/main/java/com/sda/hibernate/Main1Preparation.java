package com.sda.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
   //design pattern builder !!!

        StandardServiceRegistry registry =  new StandardServiceRegistryBuilder()
                .configure() // konfiguracja dla hibernate z resources
                .build();

// Te 3 linijki są zapisane w jednym builderem w linijce 20
//        MetadataSources metadataSources = new MetadataSources(registry);
//        Metadata metadata = metadataSources.buildMetadata();
//        SessionFactory sessionFactory1 = metadata.buildSessionFactory();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

----TRANSAKCJE -----
HIBERNATE DZIALA NA TRANSAKCJACH - RĘCZNIE NIMI OPERUJEMY !!!!
ATOMICITY - atomowo są wykonywane , jak nie wykona się cała transakcja
to zostanie wycofana w Springu i inaczej to sami
musimy ją wycofać jak nie w Springu
TRANSAKCJA SQL

START TRANSACTION

UPDATE konto SET saldo = saldo - 100 WHERE id=1;
UPDATE konto SET saldo = saldo + 100 WHERE id=2;

COMMIT;  <---Zatwierdzenie zmian
ROLLBACK; <---- Wycofanie zmian
 */

public class Main1Preparation {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    }
}
