package innosage.crm.global.exception.member;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class MemberException extends GeneralException {

    public MemberException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
