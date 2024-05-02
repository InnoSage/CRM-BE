package innosage.crm.global.exception.auth.jwt;

import innosage.crm.global.exception.common.code.GlobalErrorCode;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {

    public JwtAuthenticationException(GlobalErrorCode errorCode) {
        super(errorCode.getReason().getMessage());
    }
}
