package org.rap.cognifycommerce.auth.domain.repositories;

import org.rap.cognifycommerce.auth.infrastructure.persistence.entity.UserJpaEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserJpaEntity> findByEmail(String email);

    UserJpaEntity save(UserJpaEntity user);

    boolean existsByEmail(String email);
}
