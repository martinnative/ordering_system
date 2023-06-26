package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
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
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) throws NotFoundByIdException {
        return orderRepository.findById(id).orElseThrow(()->new NotFoundByIdException("Order with the provided ID was not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order order) throws NotFoundByIdException {

        Order existingOrder = this.getOrderById(id);

        if (existingOrder != null) {
            existingOrder.setId(order.getId());
            existingOrder.setItems(order.getItems());
            existingOrder.setCustomerAddress(order.getCustomerAddress());
            existingOrder.setCustomerName(order.getCustomerName());
            existingOrder.setCustomerPhone(order.getCustomerPhone());
            return orderRepository.save(existingOrder);
        }

        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order finishOrder(Long id) {
        return orderRepository.markOrderAsFinished(id);
    }
}
