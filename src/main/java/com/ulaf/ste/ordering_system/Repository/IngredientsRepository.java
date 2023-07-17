package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient,Long> {
    // Add any custom query methods if required
    Ingredient findByName(String name);

}
