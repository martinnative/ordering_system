package com.ulaf.ste.ordering_system.Web.requests;

import com.ulaf.ste.ordering_system.Model.OrderItem;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<OrderItem> orderItems;
    private String customerName;
    private String customerSurname;
    private String customerEmailAddress;
    private String customerPhone;

    public OrderRequest(List<OrderItem> orderItems, String customerName, String customerSurname, String customerEmailAddress, String customerPhone) {
        this.orderItems = orderItems;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhone = customerPhone;
    }

}
