package com.ulaf.ste.ordering_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany
    private List<Product_Qty> items;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
}
