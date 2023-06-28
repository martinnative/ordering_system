package com.ulaf.ste.ordering_system.Web.REST;

import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/save")
    public ResponseEntity<Image> save(MultipartFile file) throws IOException {
        return ResponseEntity.ok().body(imageService.saveImage(new Image(file.getOriginalFilename(),file.getBytes(),file.getContentType())));
    }

}
