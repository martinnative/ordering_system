package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Add any custom query methods if required
    Category findCategoryByName(String name);
}
