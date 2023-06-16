package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @ManyToMany
    private List<Product> product;


    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
