package innosage.crm.global.exception.organization;

import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.BaseErrorCode;

public class OrganizationException extends GeneralException {

    public OrganizationException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
