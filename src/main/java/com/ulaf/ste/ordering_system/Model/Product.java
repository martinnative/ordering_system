package com.ulaf.ste.ordering_system.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ListIndexBase;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean customizable;
    private Boolean available;

//    @ElementCollection
//    private List<Integer> ratings;

    @JsonManagedReference
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Ingredient> ingredients;

    @Lob
    private byte[] image;

    public Product(String name, double price,String description,Boolean customizable,Boolean available, List<Ingredient> ingredients, byte[] image, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
        this.image = image;
        this.description = description;
        this.customizable = customizable;
        this.available = available;
        //this.ratings = new ArrayList<>();
    }

//    public double calculateAverageRating() {
//        if (this.ratings.isEmpty()) {
//            return 0;
//        }
//        int sum = 0;
//        for (int rating : this.ratings) {
//            sum += rating;
//        }
//        return (double) sum / this.ratings.size();
//    }

//    public Product(Long id, String name, double price, List<Ingredient> ingredients, byte[] image, Category category) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.category = category;
//        this.ingredients = ingredients;
//        this.image = image;
//    }
//
//    public Product(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
}
