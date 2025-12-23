package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.annotation.Entity;

import java.time.LocalDateTime;

@Entity
public class RefreshToken {
    private final String token;
    private final LocalDateTime expiryDate;
    private final String deviceInfo;
    private final String ipAddress;
    private boolean revoked;

    RefreshToken(String token, long ttlMinutes, String deviceInfo, String ipAddress) {
        this.token = token;
        this.expiryDate = LocalDateTime.now().plusMinutes(ttlMinutes);
        this.deviceInfo = deviceInfo;
        this.ipAddress = ipAddress;
        this.revoked = false;
    }

    public boolean isValid() {
        return !revoked && expiryDate.isAfter(LocalDateTime.now());
    }

    public void revoke() {
        this.revoked = true;
    }
}
