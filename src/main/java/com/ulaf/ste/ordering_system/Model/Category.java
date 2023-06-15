package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String description;
    @ManyToOne
    private Product product;


    public Category(Long id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }
}