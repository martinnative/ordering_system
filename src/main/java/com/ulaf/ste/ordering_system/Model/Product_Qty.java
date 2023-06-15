package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Product_Qty {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Product product;
    private Integer quantity;

}
