package innosage.crm.global.security.jwt;

import innosage.crm.global.common.CommonResponse;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {


    private final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {
        response.setContentType("application/json; charset=UTF-8");
        response.setStatus(401);
        PrintWriter writer = response.getWriter();

        // AuthErrorCode.AUTHENTICATION_REQUIRED enum에서 코드와 메시지를 얻음
        String code = GlobalErrorCode.AUTHENTICATION_REQUIRED.getCode();
        String message = GlobalErrorCode.AUTHENTICATION_REQUIRED.getMessage();
        CommonResponse<String> apiErrorResult = CommonResponse.onFailure(code, message, null);

        writer.write(apiErrorResult.toString());
        writer.flush();
        writer.close();
    }
}