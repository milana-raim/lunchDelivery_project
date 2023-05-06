package ru.itis.yaylunch.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.AccountDto;
import ru.itis.yaylunch.dto.forms.SignUpForm;
import ru.itis.yaylunch.services.SignUpService;

@RequiredArgsConstructor
@RestController
public class SignUpController {
    private final SignUpService signUpService;

    @GetMapping("/api/students-giftery/confirm/{confirm-code}")
    public ResponseEntity<String> checkConfirmCode(String confirmCode) {
        signUpService.checkConfirm(confirmCode);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success");
    }

    @PostMapping("/api/students-giftery/signUp")
    public ResponseEntity<AccountDto> signUp(SignUpForm signUpForm) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(signUpService.signUp(signUpForm));
    }
}

