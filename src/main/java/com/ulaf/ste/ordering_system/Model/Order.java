package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<OrderItem> items;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private boolean finished;

    public Order(List<OrderItem> items, String customerName, String customerAddress, String customerPhone) {
        this.items = items;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.finished = false;
    }



}
