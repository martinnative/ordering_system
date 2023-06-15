package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Repository.OrderRepository;
import com.ulaf.ste.ordering_system.Service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        // Add any other logic needed for order creation
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Order order) {
        // Find the existing order by ID
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);

        if (existingOrder != null) {
            // Update the existing order with the new values
            // todo
            // Save the updated order
            return orderRepository.save(existingOrder);
        }

        return null; // or throw an exception indicating that the order doesn't exist
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }
}