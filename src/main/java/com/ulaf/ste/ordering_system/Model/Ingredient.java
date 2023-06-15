package com.ulaf.ste.ordering_system.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue
    private Long ID;
    private String name;


    public Ingredient(String name) {
        this.name = name;
    }
}
