package org.rap.cognifycommerce.auth.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name; // e.g., ROLE_CUSTOMER, ROLE_ADMIN

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions = new HashSet<>();
}
