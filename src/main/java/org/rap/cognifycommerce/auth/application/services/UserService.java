package org.rap.cognifycommerce.auth.application.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.domain.exception.AuthErrorCode;
import org.rap.cognifycommerce.auth.domain.exception.AuthException;
import org.rap.cognifycommerce.auth.domain.model.User;
import org.rap.cognifycommerce.auth.domain.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    UserRepository userRepository;

    // Method to load user detail by username (email)
    @Override
    @SuppressWarnings("NullableProblems")
    public User loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new AuthException(AuthErrorCode.USER_NOT_FOUND));
    }
}
