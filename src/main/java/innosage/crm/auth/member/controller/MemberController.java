package innosage.crm.auth.member.controller;

import innosage.crm.auth.member.dto.MemberRequestDto;
import innosage.crm.auth.member.dto.MemberResponseDto;
import innosage.crm.global.common.CommonResponse;
import innosage.crm.auth.member.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "users")
    public class MemberController {
    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "회원가입", description = "회원가입을 진행합니다.")
    public CommonResponse<MemberResponseDto.register> signup(@Valid @RequestBody MemberRequestDto.register request) {
       return CommonResponse.onSuccess(authService.register(request));
    }


    @PostMapping("/login")
    @Operation(summary = "로그인", description = "로그인을 진행합니다.")
    public CommonResponse<MemberResponseDto.login> login(@RequestBody MemberRequestDto.login request) {
        return CommonResponse.onSuccess(authService.login(request));
    }


    @PostMapping("/reissue")
    @Operation(summary = "토큰 재발급", description = "토큰을 재발급 합니다.")
    public CommonResponse<MemberResponseDto.reissue> reissue(@RequestBody MemberRequestDto.reissue request) {
        return CommonResponse.onSuccess(authService.reissue(request));
    }
}