package innosage.crm.global.exception.sheet;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class SheetException extends GeneralException {

    public SheetException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
