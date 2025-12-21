package org.rap.cognifycommerce.auth.domain.repositories;

import lombok.NonNull;
import org.rap.cognifycommerce.auth.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<@NonNull User, @NonNull UUID> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
