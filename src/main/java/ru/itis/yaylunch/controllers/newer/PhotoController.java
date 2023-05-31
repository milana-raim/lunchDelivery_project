package ru.itis.yaylunch.controllers.newer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.yaylunch.models.PhotoEntity;
import ru.itis.yaylunch.service.PhotoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/image")
public class PhotoController {
    private final PhotoService photoService;

    @ResponseBody
    @GetMapping("/{image-id}")
    private ResponseEntity<byte[]> getDishImage(@PathVariable(name = "image-id") Long imageId) {

        PhotoEntity photo = photoService.getById(imageId);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(photo.getBytes());
    }
}
