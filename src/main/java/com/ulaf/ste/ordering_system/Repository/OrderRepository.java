package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Add any custom query methods if required
    @Modifying
    @Transactional
    @Query("UPDATE Order o SET o.finished = true WHERE o.id = :id")
    Order markOrderAsFinished(@Param("id") Long id);
}
