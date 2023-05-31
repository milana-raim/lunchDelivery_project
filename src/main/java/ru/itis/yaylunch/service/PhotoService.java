package ru.itis.yaylunch.service;

import ru.itis.yaylunch.models.PhotoEntity;

public interface PhotoService {
    PhotoEntity getById(Long imageId);
}
