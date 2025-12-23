package org.rap.cognifycommerce.auth.application.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.application.exception.AuthErrorCode;
import org.rap.cognifycommerce.auth.application.exception.AuthException;
import org.rap.cognifycommerce.auth.domain.repositories.UserRepository;
import org.rap.cognifycommerce.auth.infrastructure.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    // Method to load user detail by username (email)
    @Override
    @SuppressWarnings("NullableProblems")
    public SecurityUser loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(SecurityUser::new)
                .orElseThrow(() -> new AuthException(AuthErrorCode.USER_NOT_FOUND));
    }
}
