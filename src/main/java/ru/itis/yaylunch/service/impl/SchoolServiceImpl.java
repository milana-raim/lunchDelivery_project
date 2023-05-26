package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.models.School;
import ru.itis.yaylunch.repositories.SchoolRepository;
import ru.itis.yaylunch.service.SchoolService;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public School save(School newSchool) {
        return schoolRepository.save(newSchool);
    }
}
