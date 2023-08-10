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
@Table(name = "ingredients_table")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    private String image;
    @ManyToMany(mappedBy = "ingredients",fetch = FetchType.LAZY)
    @JsonBackReference(value = "ingredient-reference")
    private List<Product> products;
    public Ingredient(String name,String image) {
        this.name = name;
        this.image = image;
    }
}
