package ru.itis.yaylunch.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.services.AccountsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccountsController {
    private final AccountsService accountsService;

    @GetMapping("/api/students-giftery/accounts")
    public ResponseEntity<List<AccountDto>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsService.getAccounts());
    }

    @GetMapping("/api/students-giftery/accounts/getByOrganization")
    public ResponseEntity<List<AccountDto>> getByOrganization(Long organizationId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsService.getByOrganization(organizationId));
    }
}
