package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Repository.OrderRepository;
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
}
