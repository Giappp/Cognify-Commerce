package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.annotation.Entity;

import java.util.Set;

@Entity
public class Role {
    private final String name;
    private final Set<Permission> permissions;

    public Role(String name, Set<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
