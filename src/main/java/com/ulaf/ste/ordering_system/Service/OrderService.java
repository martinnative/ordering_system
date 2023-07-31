package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Order;
import com.ulaf.ste.ordering_system.Repository.OrderRepository;
import com.ulaf.ste.ordering_system.Service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public List<Order> getTodaysOrders() {
        return orderRepository.findAll().stream().filter(order -> order.getCreatedOn().toLocalDate().equals(LocalDateTime.now().toLocalDate())).collect(Collectors.toList());
    }

    public List<Order> changeOrderStatus(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
        order.setFinished(!order.isFinished());
        orderRepository.save(order);
        return orderRepository.findAll().stream().sorted((a,b) -> Boolean.compare(a.isFinished(),b.isFinished())).collect(Collectors.toList());
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) throws NotFoundByIdException {
        return orderRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Order with the provided ID was not found"));
    }

    public Order updateOrder(Long id, Order order) throws NotFoundByIdException {

        Order existingOrder = this.getOrderById(id);

        if (existingOrder != null) {
            existingOrder.setId(order.getId());
            existingOrder.setItems(order.getItems());
            existingOrder.setCustomerEmailAddress(order.getCustomerEmailAddress());
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setCustomerPhone(order.getCustomerPhone());
            return orderRepository.save(existingOrder);
        }

        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order finishOrder(Long id) throws NotFoundByIdException {
        Order order = orderRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Order with the provided ID was not found"));;
        order.setFinished(true);
        return order;
    }
}
