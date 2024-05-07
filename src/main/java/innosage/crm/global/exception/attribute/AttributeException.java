package innosage.crm.global.exception.attribute;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class AttributeException extends GeneralException {

    public AttributeException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
