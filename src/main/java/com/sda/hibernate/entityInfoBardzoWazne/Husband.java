package com.sda.hibernate.entityInfoBardzoWazne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}) // usuwanie kaskadowe czyli z dwóch tabel połączonych
                                                                  // usunie oba rekody z jednej i drugiej tabeli
    @JoinColumn(name ="my_wife_id")
    Wife wife;

    public Husband(String name) {
        this.name = name;
        this.wife = wife;

    }
    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

}
