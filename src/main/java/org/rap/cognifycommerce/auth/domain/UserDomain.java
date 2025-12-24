package org.rap.cognifycommerce.auth.domain;

import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.rap.cognifycommerce.auth.domain.event.PasswordChangedEvent;
import org.rap.cognifycommerce.auth.domain.event.UserLoggedInEvent;
import org.rap.cognifycommerce.auth.domain.event.UserRegisteredEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@org.jmolecules.ddd.annotation.AggregateRoot
@SuppressWarnings("NullableProblems")
public class UserDomain extends AbstractAggregateRoot<UserDomain> implements AggregateRoot<UserDomain, UserId> {
    private final List<RefreshToken> refreshTokens = new ArrayList<>();
    private final Set<Role> roles = new HashSet<>();
    private final List<SocialAccount> socialAccounts = new ArrayList<>();
    private final UserId id;
    private final Email email;
    private Password password;
    // AI-driven metadata (stored as JSONB in DB)
    private UserMetadata metadata;

    private UserDomain(UserId id, Email email, Password password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static UserDomain register(UserId id, Email email, Password password) {
        UserDomain user = new UserDomain(id, email, password);
        user.registerEvent(new UserRegisteredEvent(id, email));
        return user;
    }

    public void setMetadata(UserMetadata metadata) {
        this.metadata = metadata;
    }

    public void updatePassword(Password newPassword) {
        this.password = newPassword;

        this.registerEvent(new PasswordChangedEvent());
    }

    public void addSession(String token, LocalDateTime expiredAt, String device, String ip) {
        if (this.refreshTokens.size() >= 5) {
            this.refreshTokens.removeFirst(); // Revoke oldest session
        }

        RefreshToken newSession = new RefreshToken(token, expiredAt, device, ip);
        this.refreshTokens.add(newSession);

        // Notify system of a successful login
        registerEvent(new UserLoggedInEvent(this.id, device, ip));
    }

    public void linkSocialAccount(String provider, String providerId, String pictureUrl) {
        SocialAccount account = new SocialAccount(provider, providerId, pictureUrl);
        this.socialAccounts.add(account);
    }

    public void assignRole(Role role) {
        this.roles.add(role);
    }

    @Override
    public UserId getId() {
        return id;
    }
}
