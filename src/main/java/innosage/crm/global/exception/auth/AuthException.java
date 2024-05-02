package innosage.crm.global.exception.auth;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class AuthException extends GeneralException {

    public AuthException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
