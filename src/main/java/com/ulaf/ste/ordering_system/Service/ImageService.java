package com.ulaf.ste.ordering_system.Service;

import com.ulaf.ste.ordering_system.Model.Image;

public interface ImageService {
    Image saveImage(Image image);
    Image findById(Long id);
}
