package com.ulaf.ste.ordering_system.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String name;
    @Lob
    private byte[] image;
    public Ingredient(String name,byte[] image) {
        this.name = name;
        this.image = image;
    }

    public Ingredient(String name) {
        this.name = name;
    } // TODO:Remove this after creating api call to create with image
}
