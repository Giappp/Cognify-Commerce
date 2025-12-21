package org.rap.cognifycommerce.common.api;

import java.time.LocalDateTime;

public record ApiError(
        String code,
        String message,
        LocalDateTime timestamp
) {
}