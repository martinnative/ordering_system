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
@Data
public class OrderRequest {

     Long id;
     List<OrderItem> orderItems;
     String customerName;
     String customerSurname;
     String customerEmailAddress;
     String customerPhone;



}
