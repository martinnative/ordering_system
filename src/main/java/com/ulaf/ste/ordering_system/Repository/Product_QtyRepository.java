package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Product_Qty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product_QtyRepository extends JpaRepository<Product_Qty, Long> {
    // Add any custom query methods if required

}
