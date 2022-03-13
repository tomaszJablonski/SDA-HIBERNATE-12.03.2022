package com.sda.hibernate.entityInfoBardzoWazne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(mappedBy = "wife")
    Husband husband;

    public Wife(String name) {
        this.name = name;
    }
    //tego tak nie robić raczej bo z bazy danych się wyciąga dane
    public void setHusband(Husband husband){
        this.husband = husband;
        this.husband.setWife(this);
    }
}
