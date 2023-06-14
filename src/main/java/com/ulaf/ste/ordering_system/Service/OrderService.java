package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    // Add other relevant methods
}
