package org.rap.cognifycommerce.auth.domain.event;

public record UserLoggedInEvent(org.rap.cognifycommerce.auth.domain.UserId id, String device, String ip) {
}
