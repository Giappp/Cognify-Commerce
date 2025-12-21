package org.rap.cognifycommerce.auth.domain.exception;

import lombok.Getter;

@Getter
public enum AuthErrorCode {
    INVALID_CREDENTIALS("AUTH_001", "Invalid username or password"),
    USER_NOT_FOUND("AUTH_002", "User not found"),
    TOKEN_REVOKED("AUTH_003", "Token has been revoked"),
    TOKEN_INVALID("AUTH_004", "Invalid token"),
    TOKEN_EXPIRED("AUTH_005", "Token has expired");
    private final String errorCode;
    private final String defaultMessage;

    AuthErrorCode(String errorCode, String defaultMessage) {
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
    }
}
