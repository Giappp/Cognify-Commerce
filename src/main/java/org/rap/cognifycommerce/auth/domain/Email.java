package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Email(String value) {
    public Email {
        if (!value.contains("@")) {
            throw new IllegalArgumentException("Email không hợp lệ");
        }
    }
}
