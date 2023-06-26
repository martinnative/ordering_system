package com.ulaf.ste.ordering_system.Model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<OrderItem> items;
    private String customerName;
    private String customerSurname;
    private String customerEmailAddress;
    private String customerPhone;
    private boolean finished;

    public Order(List<OrderItem> items, String customerName, String customerSurname, String customerEmailAddress, String customerPhone) {
        this.items = items;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhone = customerPhone;
    }
}
