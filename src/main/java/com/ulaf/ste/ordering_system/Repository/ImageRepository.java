package com.ulaf.ste.ordering_system.Repository;

import com.ulaf.ste.ordering_system.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
