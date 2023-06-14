package com.ulaf.ste.ordering_system.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ingredients {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;


    public Ingredients(String name) {
        this.name = name;
    }


    public Ingredients() {

    }
}
