package com.ulaf.ste.ordering_system.Service;
import com.ulaf.ste.ordering_system.Model.Image;
import com.ulaf.ste.ordering_system.Repository.ImageRepository;
import com.ulaf.ste.ordering_system.Service.ImageService;
import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(Image image)  {
        Image compressedImage = compressImage(image);
        return imageRepository.save(compressedImage);
    }

    public Image findById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @SneakyThrows
    private Image compressImage(Image image)  {
        byte[] imageData = image.getBytes();
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        ByteArrayOutputStream compressedImageStream = new ByteArrayOutputStream();
        try {
            Thumbnails.of(originalImage)
                    .size(500, 300)
                    .outputQuality(0.8)
                    .outputFormat("png")
                    .toOutputStream(compressedImageStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] compressedImageData = compressedImageStream.toByteArray();
        image.setBytes(compressedImageData);

        return image;
    }
}



