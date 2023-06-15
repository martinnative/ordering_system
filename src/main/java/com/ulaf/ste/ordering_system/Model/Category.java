package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Category {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String description;
    @ManyToOne
    private Product product;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
