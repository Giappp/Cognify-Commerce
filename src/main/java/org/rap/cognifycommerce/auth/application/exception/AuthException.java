package org.rap.cognifycommerce.auth.application.exception;

import lombok.Getter;
import lombok.Setter;
import org.rap.cognifycommerce.common.domain.DomainException;

@Getter
@Setter
public class AuthException extends DomainException {
    private AuthErrorCode errorCode;

    public AuthException(AuthErrorCode error) {
        super(error.getErrorCode(), error.getDefaultMessage());
        this.errorCode = error;
    }
}
