package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Category;
import com.ulaf.ste.ordering_system.Model.ProductQty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductQtyRepository extends JpaRepository<ProductQty, Long> {
    // Add any custom query methods if required
    List<ProductQty> findProduct_QtyByProductCategory(Category category);

}
