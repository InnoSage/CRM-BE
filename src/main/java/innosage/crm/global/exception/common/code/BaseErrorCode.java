package innosage.crm.global.exception.common.code;

import innosage.crm.global.exception.common.ErrorReason;

public interface BaseErrorCode {

    public ErrorReason getReason();

    public ErrorReason getReasonHttpStatus();
}
