package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Add any custom query methods if required
    List<OrderItem> findOrderItemByProductCategory(Category category);

}
