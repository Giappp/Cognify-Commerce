package org.rap.cognifycommerce.auth.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "refresh_tokens")
@Getter
@Setter
public class RefreshToken extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(nullable = false, updatable = true)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private boolean revoked = false;

    private String deviceInfo;

    private String ipAddress;
}
