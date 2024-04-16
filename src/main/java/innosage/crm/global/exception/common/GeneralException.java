package innosage.crm.global.exception.common;

import innosage.crm.global.exception.common.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode errorCode;

    public ErrorReason getErrorReason() {
        return this.errorCode.getReason();
    }

    public ErrorReason getErrorReasonHttpStatus() {
        return this.errorCode.getReasonHttpStatus();
    }
}
