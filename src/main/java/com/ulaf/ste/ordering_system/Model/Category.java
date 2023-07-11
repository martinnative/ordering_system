package com.ulaf.ste.ordering_system.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @OneToOne
    private Image image;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, String description, Image image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
