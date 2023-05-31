package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.response.DishResponse;
import ru.itis.yaylunch.dto.response.SchoolResponse;
import ru.itis.yaylunch.mapper.SchoolMapper;
import ru.itis.yaylunch.models.School;
import ru.itis.yaylunch.repositories.SchoolRepository;
import ru.itis.yaylunch.service.SchoolService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Override
    public School save(School newSchool) {
        return schoolRepository.save(newSchool);
    }

    @Override
    public List<SchoolResponse> getAll() {
        System.out.println(schoolMapper.toResponse(schoolRepository.findAll()));
        return schoolMapper.toResponse(schoolRepository.findAll());
    }
}
