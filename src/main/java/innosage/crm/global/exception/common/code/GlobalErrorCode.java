package innosage.crm.global.exception.common.code;

import innosage.crm.global.exception.common.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements BaseErrorCode {
    //Global
    // 500 Server Error
    SERVER_ERROR(INTERNAL_SERVER_ERROR, "GLOBAL500_1", "서버 에러, 서버 개발자에게 알려주세요."),

    // Args Validation Error
    BAD_ARGS_ERROR(BAD_REQUEST, "GLOBAL400_1", "request body의 validation이 실패했습니다. 응답 body를 참고해주세요"),

    // Auth
    // 401 Unauthorized - 권한 없음
    TOKEN_EXPIRED(UNAUTHORIZED, "AUTH401_1", "인증 토큰이 만료 되었습니다. 토큰을 재발급 해주세요"),
    INVALID_TOKEN(UNAUTHORIZED, "AUTH401_2", "인증 토큰이 유효하지 않습니다."),
    INVALID_REFRESH_TOKEN(UNAUTHORIZED, "AUTH401_3", "리프레시 토큰이 유효하지 않습니다."),
    REFRESH_TOKEN_EXPIRED(UNAUTHORIZED, "AUTH401_4", "리프레시 토큰이 만료 되었습니다."),
    AUTHENTICATION_REQUIRED(UNAUTHORIZED, "AUTH401_5", "인증 정보가 유효하지 않습니다."),
    LOGIN_REQUIRED(UNAUTHORIZED, "AUTH401_6", "로그인이 필요한 서비스입니다."),

    // 403 Forbidden - 인증 거부
    AUTHENTICATION_DENIED(FORBIDDEN, "AUTH403_1", "인증이 거부 되었습니다."),

    // 404 Not Found - 찾을 수 없음
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "AUTH404_1", "리프레시 토큰이 존재하지 않습니다."),

    //Member
    // 404 Not Found - 찾을 수 없음
    MEMBER_NOT_FOUND(NOT_FOUND, "MEMBER404_1", "회원을 찾을 수 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReason getReason() {
        return ErrorReason.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReason getReasonHttpStatus() {
        return ErrorReason.builder()
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .isSuccess(false)
                .build();
    }

}
