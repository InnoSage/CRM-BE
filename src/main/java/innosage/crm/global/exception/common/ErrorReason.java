package innosage.crm.global.exception.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorReason {

    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;
}
