package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Qty {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;
    private int quantity;

}
