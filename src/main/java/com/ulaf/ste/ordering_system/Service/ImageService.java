package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Image saveImage(Image image);
    Image findById(Long id);
    List<Image> findAll();
}
