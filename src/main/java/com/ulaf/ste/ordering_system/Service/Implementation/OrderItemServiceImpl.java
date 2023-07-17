package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Exceptions.NotFoundByIdException;
import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.OrderItem;
import com.ulaf.ste.ordering_system.Repository.CategoryRepository;
import com.ulaf.ste.ordering_system.Repository.OrderItemRepository;
import com.ulaf.ste.ordering_system.Service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final CategoryRepository categoryRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, CategoryRepository categoryRepository) {
        this.orderItemRepository = orderItemRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getOrderItemById(Long id) throws NotFoundByIdException {
        return orderItemRepository.findById(id).orElseThrow(()->new NotFoundByIdException("ID was not found"));
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) throws NotFoundByIdException {
        OrderItem existingProduct = this.getOrderItemById(id);

        if (existingProduct != null) {
            existingProduct.setProduct(orderItem.getProduct());
            existingProduct.setQuantity(orderItem.getQuantity());
            return orderItemRepository.save(existingProduct);
        }

        throw new NotFoundByIdException("ID was not found.");
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public void saveAll(List<OrderItem> list) {
        orderItemRepository.saveAll(list);
    }

    @Override
    public List<OrderItem> findAllOrderItemsWithCategory(String category) throws NotFoundByIdException {
        Category existingCategory = categoryRepository.findCategoryByName(category);
        if(existingCategory!=null)
        {
            return orderItemRepository.findOrderItemByProductCategory(existingCategory);
        }
        throw new NotFoundByIdException("Category not found.");
    }

    @Override
    public List<OrderItem> findAllByIds(List<Long> orderItemIds) {
        return orderItemRepository.findAllById(orderItemIds);
    }
}
