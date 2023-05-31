package ru.itis.yaylunch.service;

import ru.itis.yaylunch.dto.response.SchoolResponse;
import ru.itis.yaylunch.models.School;

import java.util.List;

public interface SchoolService {
    School save(School newSchool);

    List<SchoolResponse> getAll();
}
