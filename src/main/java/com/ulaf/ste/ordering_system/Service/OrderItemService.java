package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long id) throws NotFoundByIdException;
    List<OrderItem> getAllOrderItem();
    OrderItem updateOrderItem(Long id, OrderItem orderItem) throws NotFoundByIdException;

    void deleteOrderItem(Long id);

    List<OrderItem> findAllOrderItemsWithCategory(String category) throws NotFoundByIdException;
}
