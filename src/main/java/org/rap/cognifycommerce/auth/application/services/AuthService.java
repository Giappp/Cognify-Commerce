package org.rap.cognifycommerce.auth.application.services;

import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.infrastructure.persistence.jpa.JpaUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    UserDetailsServiceImpl userService;
    JpaUserRepository jpaUserRepository;
}
