package org.rap.cognifycommerce.auth.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.BaseEntity;

@Entity
@Table(name = "social_accounts")
@Getter
@Setter
public class SocialAccount extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String provider; // e.g., "google", "facebook"

    @Column(name = "provider_id")
    private String providerId;
}
