package com.ulaf.ste.ordering_system.Web.requests;

import com.ulaf.ste.ordering_system.Model.Product;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@Data
public class OrderItemRequest {
    private Long productId;
    private int quantity;
    private List<String> notIngredients;
}
