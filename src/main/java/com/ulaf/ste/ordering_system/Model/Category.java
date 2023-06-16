package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String description;

//    @ManyToOne
//    private Product product;
    //NEMA POTREBA DA SE CHUVA PRODUKT U KATEGORIJA
    //KJE SE CHUVA LISTA OD KATEGORIE ZA SVAKI PRODUCT U CLASA PRODUCT

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
