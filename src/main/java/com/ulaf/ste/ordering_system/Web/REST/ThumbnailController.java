package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Service.ImageService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/thumbnails")
public class ThumbnailController {

    private final ImageService imageService;

    public ThumbnailController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getThumbnail(@PathVariable Long id) {
        try {
            // Retrieve the image from the image service using the provided ID
            Image image = imageService.findById(id);
            if (image == null) {
                return ResponseEntity.notFound().build();
            }
            // Load the original image file
            Path imagePath = Paths.get("images/", image.getName());
            UrlResource resource = new UrlResource(imagePath.toUri());

            // Generate a thumbnail with a desired size
            Thumbnails.Builder thumbnailBuilder = Thumbnails.of(resource.getFile())
                    .size(300, 300); // Adjust the dimensions as per your requirement

            // Apply any additional configurations if needed (e.g., compression, watermark)

            // Save the thumbnail to a temporary file
            Path thumbnailPath = Paths.get("thumbnails/", image.getName());
            thumbnailBuilder.toFile(thumbnailPath.toFile());

            // Serve the thumbnail as a response
            Resource thumbnailResource = new UrlResource(thumbnailPath.toUri());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust the media type as per your image format
                    .body(thumbnailResource);
        } catch (IOException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}

