package org.rap.cognifycommerce.auth.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.BaseEntity;

@Entity
@Table(name = "social_accounts")
@Getter
@Setter
public class SocialAccountJpaEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    private String provider; // e.g., "google", "facebook"

    @Column(name = "provider_id")
    private String providerId;
    
    private String profileUrl;
}
