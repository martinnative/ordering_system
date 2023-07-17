package com.ulaf.ste.ordering_system.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
    private int quantity;
    @ManyToMany
    private List<Ingredient> notIngredients;

    public OrderItem(Product product, int quantity, List<Ingredient> notIngredients) {
        this.product = product;
        this.quantity = quantity;
        this.notIngredients = notIngredients;
    }
}
