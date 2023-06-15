package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Add any custom query methods if required
}
