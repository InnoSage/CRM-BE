package innosage.crm.global.security.jwt;

import innosage.crm.global.common.CommonResponse;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


import java.io.IOException;
import java.io.PrintWriter;


public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(403);
        PrintWriter writer = response.getWriter();

        // AuthErrorCode.AUTHENTICATION_DENIED enum에서 코드와 메시지를 얻음
        String code = GlobalErrorCode.AUTHENTICATION_DENIED.getCode();
        String message = GlobalErrorCode.AUTHENTICATION_DENIED.getMessage();
        CommonResponse<String> apiErrorResult = CommonResponse.onFailure(code, message, null);
        writer.write(apiErrorResult.toString());
        writer.flush();
        writer.close();
    }
}