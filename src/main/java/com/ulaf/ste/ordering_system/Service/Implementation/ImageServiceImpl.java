package com.ulaf.ste.ordering_system.Service.Implementation;

import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Repository.ImageRepository;
import com.ulaf.ste.ordering_system.Service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image findById(Long id) {
        return this.imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> findAll() {
        return this.imageRepository.findAll();
    }

}
