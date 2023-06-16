package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<Product_Qty> items;
    private String customerName;
    private String customerAddress;

    public Order(List<Product_Qty> items, String customerName, String customerAddress, String customerPhone) {
        this.items = items;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    private String customerPhone;

}
