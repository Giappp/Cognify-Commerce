package org.rap.cognifycommerce.auth.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.application.dto.SignInRequest;
import org.rap.cognifycommerce.auth.application.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserDetailsServiceImpl userService;

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest request) {
        return ResponseEntity.ok()
                .build();
    }
}
