package org.rap.cognifycommerce.auth.infrastructure.persistence.jpa;

import lombok.NonNull;
import org.rap.cognifycommerce.auth.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<@NonNull UserJpaEntity, @NonNull UUID> {
    Optional<UserJpaEntity> findByEmail(String email);

    Optional<UserJpaEntity> findByUsername(String username);

    boolean existsByEmail(String email);
}
