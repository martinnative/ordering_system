package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Service.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/compressed")
public class CompressionController {

    private final ImageService imageService;

    public CompressionController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getCompressedImage(@PathVariable Long id) {
        try {
            // Retrieve the image from the image service using the provided ID
            Image image = imageService.findById(id);
            if (image == null) {
                return ResponseEntity.notFound().build();
            }

            // Load the original image file
            Path imagePath = Paths.get("images/", image.getName());
            UrlResource resource = new UrlResource(imagePath.toUri());

            // Read the original image into a BufferedImage
            BufferedImage originalImage = ImageIO.read(resource.getInputStream());

            // Create a ByteArrayOutputStream to hold the compressed image data
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // Compress the image using JPEG format and desired compression quality
            ImageIO.write(originalImage, "jpeg", outputStream);

            // Get the compressed image data as a byte array
            byte[] compressedImageData = outputStream.toByteArray();

            // Serve the compressed image as a response
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Adjust the media type as per your image format
                    .body(compressedImageData);
        } catch (IOException e) {
            // Handle exceptions appropriately
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
