package org.rap.cognifycommerce.auth.infrastructure.security;

import org.jspecify.annotations.Nullable;
import org.rap.cognifycommerce.auth.infrastructure.persistence.entity.UserJpaEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Map;

public class SecurityUser implements UserDetails {
    private final UserJpaEntity userEntity;

    public SecurityUser(UserJpaEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Map<String, Object> getAiMetadata() {
        return userEntity.getMetadata();
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userEntity.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return userEntity.getPasswordHash();
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public String getUsername() {
        return userEntity.getEmail();
    }
}
