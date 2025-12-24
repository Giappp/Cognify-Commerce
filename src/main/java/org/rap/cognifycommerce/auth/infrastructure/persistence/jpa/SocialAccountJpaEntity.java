package org.rap.cognifycommerce.auth.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialAccountJpaEntity extends JpaRepository<SocialAccountJpaEntity, UUID> {
}
