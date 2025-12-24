package org.rap.cognifycommerce.auth.domain;

import lombok.Getter;
import org.jmolecules.ddd.annotation.Entity;

@Entity
@Getter
public class SocialAccount {
    private final String provider;
    private final String providerId;
    private final String pictureUrl;

    public SocialAccount(String provider, String providerId, String pictureUrl) {
        this.provider = provider;
        this.providerId = providerId;
        this.pictureUrl = pictureUrl;
    }
}
