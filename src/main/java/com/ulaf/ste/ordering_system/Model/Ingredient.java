package com.ulaf.ste.ordering_system.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    @OneToOne
    private Image image;
    @ManyToMany(mappedBy = "ingredients")
    @JsonBackReference("ingredient-reference")
    private List<Product> product;
    public Ingredient(String name,Image image) {
        this.name = name;
        this.image = image;
    }
}
