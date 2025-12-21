package org.rap.cognifycommerce.auth.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.BaseEntity;

@Entity
@Table(name = "permissions")
@Getter
@Setter
public class Permission extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name; // e.g., "product:read", "order:create"
}
