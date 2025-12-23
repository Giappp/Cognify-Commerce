package org.rap.cognifycommerce.auth.domain.event;

import org.rap.cognifycommerce.auth.domain.Email;
import org.rap.cognifycommerce.auth.domain.UserId;

public record UserRegisteredEvent(UserId userId, Email email) {
}
