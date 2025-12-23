package org.rap.cognifycommerce.auth.domain;

import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.rap.cognifycommerce.auth.domain.event.UserLoggedInEvent;
import org.rap.cognifycommerce.auth.domain.event.UserRegisteredEvent;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.ArrayList;
import java.util.List;

@Getter
@org.jmolecules.ddd.annotation.AggregateRoot
class UserDomain extends AbstractAggregateRoot<UserDomain> implements AggregateRoot<UserDomain, UserId> {
    private final List<RefreshToken> refreshTokens = new ArrayList<>();
    // AI-driven metadata (stored as JSONB in DB)
    private UserMetadata metadata;
    private UserId id;
    private Email email;
    private Password password;

    private UserDomain(UserId id, Email email, Password password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public static UserDomain register(UserId id, Email email, Password password) {
        UserDomain user = new UserDomain(id, email, password);
        // Register event for other modules (e.g., Intelligence to create a profile)
        user.registerEvent(new UserRegisteredEvent(id, email));
        return user;
    }

    public void addSession(String token, long ttlMinutes, String device, String ip) {
        // Security constraint: Limit to 5 active sessions
        if (this.refreshTokens.size() >= 5) {
            this.refreshTokens.removeFirst(); // Revoke oldest session
        }

        RefreshToken newSession = new RefreshToken(token, ttlMinutes, device, ip);
        this.refreshTokens.add(newSession);

        // Notify system of a successful login
        registerEvent(new UserLoggedInEvent(this.id, device, ip));
    }
}
