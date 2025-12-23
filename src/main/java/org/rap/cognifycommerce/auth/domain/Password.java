package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Password(String hash) {
}
