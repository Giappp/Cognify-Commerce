package org.rap.cognifycommerce.auth.application.services;

import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    UserService userService;
    UserRepository userRepository;
}
