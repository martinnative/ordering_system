package com.ulaf.ste.ordering_system.jobs;

import com.ulaf.ste.ordering_system.Model.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @PostConstruct
    public void initializeData() {
        //TODO: generate dummy data to show on frontend
    }
}
