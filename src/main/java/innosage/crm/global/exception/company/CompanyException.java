package innosage.crm.global.exception.company;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class CompanyException extends GeneralException {

    public CompanyException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
