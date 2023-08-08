package com.ulaf.ste.ordering_system.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<OrderItem> items;
    private String customerName;
    private String customerSurname;
    private String customerEmailAddress;
    private String customerPhone;
    private boolean finished;
    @JsonFormat(pattern = "dd-MM-YYYY hh:mm:ss")
    private LocalDateTime createdOn;

    public Order(List<OrderItem> items, String customerName, String customerSurname, String customerEmailAddress, String customerPhone,LocalDateTime createdOn) {
        this.items = items;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhone = customerPhone;
        this.createdOn = createdOn;
    }

    public Order(List<OrderItem> items, String customerName, String customerSurname, String customerEmailAddress, String customerPhone, boolean finished) {
        this.items = items;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhone = customerPhone;
        this.finished = finished;
    }
}
