package ru.itis.yaylunch.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.itis.yaylunch.dto.response.ClientSchoolResponse;
import ru.itis.yaylunch.mapper.ClientMapper;
import ru.itis.yaylunch.models.Account;
import ru.itis.yaylunch.repositories.ClientRepository;
import ru.itis.yaylunch.service.AccountService;
import ru.itis.yaylunch.service.ClientService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final AccountService accountService;
    private final ClientMapper clientMapper;
    @Override
    public List<ClientSchoolResponse> getAllBySchool() {
        Account account = accountService.getCurrentAccountFromSecurityContext().get();
        return clientMapper.toResponse(clientRepository.findAllBySchool_Id(account.getSchool().getId()));
    }
}
