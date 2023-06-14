package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Product_Qty {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;
    private Integer quantity;

}
