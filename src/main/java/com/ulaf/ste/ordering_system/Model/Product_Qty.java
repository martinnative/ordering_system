package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product_Qty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;
    private int quantity;

    public Product_Qty(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
