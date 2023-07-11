package com.ulaf.ste.ordering_system.Model;


import jakarta.persistence.*;
import lombok.*;

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
    public Ingredient(String name,Image image) {
        this.name = name;
        this.image = image;
    }
}
