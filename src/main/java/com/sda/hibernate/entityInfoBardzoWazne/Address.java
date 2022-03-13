package com.sda.hibernate.entityInfoBardzoWazne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

//Embeddable dopisujemy to żeby inna klasa do sql mogła z niej korzystać.
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    String city;
    String street;
}
