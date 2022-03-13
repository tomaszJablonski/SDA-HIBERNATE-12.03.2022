package com.sda.hibernate.entityInfoBardzoWazne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
@NoArgsConstructor
@Setter
@Getter
public class Employee {
/*
    //Field acces - uzyskuje dostęp do pola encji bezpośrednio
    //Property Access się nie stosuje raczej bo to komplikuje sprawę
    // bo trzeba robić dla wszystkich gettery i settery

    //Kluczem może być String UUID albo Long (mogą być też date,bigdecimal,BigInteger - ale tego się nie stosuje)

    //GeneratedValue SEQUENCE - wewnętrzna struktura danych,jest przystosowana do pracy równoległej milion klientów naraz
                   @SequenceGenerator(name ="myGen",sequanceName ="mySeq",initialValue =5,allocationSize=10)
                   @GenerationType(strategy = GenerationType.SEQUENCE,generator = "myGen"
                   AUTO - domyślna wartość
                   *****IDENTITY - tłumaczone na auto.increment najczęściej używane
                   TABLE - to samo co SEQUENCE ale jest wolne i trzeba czekać aż pierwszy dostanie odpowiedź itd.

    // najlepiej IDENTITY albo SEQUENCE w zależności id bazy danych
    //SEQUENEC PostgreSQL
    //IDENTITY MySQL

    Obiekty
    Nie posiada pola @id
    Musi posiadać bezargumentowy konstruktor
    Nie podajemy
    @Embeded - dodatkowa klasa z której kożystamy w głównym Entity
    @Embeddable - używana klasa osobna

    //Relacje
    //Relacja jednokierunkowa
    @OneToOne
    Wife wife z klasy Wife Relacja jeden do jednego
    tutaj informacja jest wife_id

    //Relacja dwukierunkowa
    ///@OneToOne and @OneToOne
    Umieścić te polecenia  w dwóch encjach gdzie chcemy mieć taką relacje
    @OneToOne
    @JoinColumn(name = "my_husband_id)
    Wife wife
    @OneToOne(mappedBy = "wife")
    Husband husband
    Trzeba ustawić właściciela relacji

    //CascadeType
    Persist - dodawnie
    Remowe - usuwanie




    */

    @Id // tu  jest to Field access
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(name = "password")
    String secret;
    @Column(length = 9, unique = true)
    String telephoneNumber;
    @Transient
    Long age;
    @Temporal(TemporalType.DATE)
    Date birthDate;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Lob
    String description; // ---> description TEXT
    @Embedded
    Address address;

    public enum Gender{
        FEMALE,MALE
    }

    public Employee(String name, String secret, String telephoneNumber, Long age, Date birthDate, Gender gender, String description) {
        this.name = name;
        this.secret = secret;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.description = description;
    }
}
