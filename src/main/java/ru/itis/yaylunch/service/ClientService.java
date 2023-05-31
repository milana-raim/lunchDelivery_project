package ru.itis.yaylunch.service;

import ru.itis.yaylunch.dto.response.ClientSchoolResponse;

import java.util.List;

public interface ClientService {

    List<ClientSchoolResponse> getAllBySchool();
}
