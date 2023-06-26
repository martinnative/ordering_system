package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Ingredient;
import com.ulaf.ste.ordering_system.Model.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id) throws NotFoundByIdException;
    List<Order> getAllOrders();
    Order updateOrder(Long id, Order order) throws NotFoundByIdException;
    void deleteOrder(Long id);

    Order finishOrder(Long id) throws NotFoundByIdException;
}
