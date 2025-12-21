package org.rap.cognifycommerce.common.domain;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {
    private final String errorCode;
    private final String message;

    protected DomainException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
