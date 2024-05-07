package innosage.crm.global.exception.deal;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class DealException extends GeneralException {

    public DealException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
