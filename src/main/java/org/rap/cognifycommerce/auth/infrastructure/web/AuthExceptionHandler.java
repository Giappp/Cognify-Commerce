package org.rap.cognifycommerce.auth.infrastructure.web;

import org.rap.cognifycommerce.auth.application.exception.AuthException;
import org.rap.cognifycommerce.common.api.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(AuthException.class)
    @SuppressWarnings("NullableProblems")
    public ResponseEntity<ApiError> handleAuthException(AuthException ex) {
        HttpStatus status = switch (ex.getErrorCode()) {
            case USER_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case INVALID_CREDENTIALS, TOKEN_REVOKED, TOKEN_EXPIRED -> HttpStatus.UNAUTHORIZED;
            case TOKEN_INVALID -> HttpStatus.FORBIDDEN;
            default -> HttpStatus.NOT_FOUND;
        };
        return ResponseEntity.status(status)
                .body(new ApiError(
                        ex.getErrorCode().getErrorCode(),
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }
}
