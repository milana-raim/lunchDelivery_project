package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.exceptions.NotFoundException;
import ru.itis.yaylunch.exceptions.PhotoNotFoundException;
import ru.itis.yaylunch.models.PhotoEntity;
import ru.itis.yaylunch.repositories.PhotoRepository;
import ru.itis.yaylunch.service.PhotoService;

@RequiredArgsConstructor
@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;

    @Override
    public PhotoEntity getById(Long imageId) {
        return photoRepository.findById(imageId)
                .orElseThrow(PhotoNotFoundException::new);
    }
}
