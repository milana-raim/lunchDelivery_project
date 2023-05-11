package ru.itis.yaylunch.controllers.old;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.yaylunch.dto.forms.SignInForm;

@RestController
public class SignInController {
    @PostMapping("/api/students-giftery/signIn/")
    public ResponseEntity<String> signIn(SignInForm body) {
        return ResponseEntity.ok("Success");
    }
}
