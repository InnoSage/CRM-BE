package innosage.crm.member.controller;

import innosage.crm.global.auth.TokenDto;
import innosage.crm.global.common.CommonResponse;
import innosage.crm.member.dto.LoginRequestDto;
import innosage.crm.member.dto.MemberRequestDto;
import innosage.crm.member.dto.MemberResponseDto;
import innosage.crm.member.dto.TokenRequestDto;
import innosage.crm.member.entity.Member;
import innosage.crm.member.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
    public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse<MemberResponseDto>> signup(@Valid @RequestBody MemberRequestDto memberRequestDto) {
        try {
            MemberResponseDto memberResponse = authService.signup(memberRequestDto); // Assume this method handles the signup logic
            CommonResponse<MemberResponseDto> response = CommonResponse.onSuccess(memberResponse);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            CommonResponse<MemberResponseDto> response = CommonResponse.onFailure("ERROR_CODE", e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<CommonResponse<TokenDto>> login(@RequestBody LoginRequestDto loginRequestDto) {

        try {
            TokenDto tokenDto = authService.login(loginRequestDto); // Assume this method handles the login logic
            CommonResponse<TokenDto> response = CommonResponse.onSuccess(tokenDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            CommonResponse<TokenDto> response = CommonResponse.onFailure("ERROR_CODE", e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }

    }


    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}