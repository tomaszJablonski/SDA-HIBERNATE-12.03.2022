package com.sda.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="dog") // podawać za każdym razem
@Data
@NoArgsConstructor // bezargumentowy konstruktor
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String race;

    //przy NonArgsConstructor to jest nie potrzebne
    //public Dog() {
   // }

    public Dog(String name, Integer age, String race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

}
