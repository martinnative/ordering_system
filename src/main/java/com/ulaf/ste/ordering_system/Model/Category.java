package com.ulaf.ste.ordering_system.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;
    @Lob
    private byte[] image;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    } // TODO:Remove this after creating api call to create with image

    public Category(String name, String description, byte[] image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
