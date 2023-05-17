package ru.itis.yaylunch.repositories.newer;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.yaylunch.models.newer.PhotoEntity;

import java.io.IOException;
import java.util.Optional;

public interface PhotoRepository {

    String savePhoto(MultipartFile file) throws IOException;

    void delete(String id);

    Optional<PhotoEntity> findById(String id) throws IOException;
}

