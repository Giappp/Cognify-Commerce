package org.rap.cognifycommerce.auth.domain;

import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

public record UserId(UUID value) implements Identifier {
}
