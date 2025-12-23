package org.rap.cognifycommerce.auth.infrastructure.persistence;

import lombok.RequiredArgsConstructor;
import org.rap.cognifycommerce.auth.domain.repositories.UserRepository;
import org.rap.cognifycommerce.auth.infrastructure.persistence.entity.UserJpaEntity;
import org.rap.cognifycommerce.auth.infrastructure.persistence.jpa.JpaUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    @Override
    public Optional<UserJpaEntity> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email);
    }

    @Override
    public UserJpaEntity save(UserJpaEntity user) {
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
