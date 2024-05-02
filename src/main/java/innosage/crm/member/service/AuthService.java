package innosage.crm.member.service;


import innosage.crm.global.exception.auth.AuthException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.member.MemberException;
import innosage.crm.global.redis.entity.RefreshToken;
import innosage.crm.global.security.jwt.TokenDto;
import innosage.crm.global.redis.service.RedisService;
import innosage.crm.member.dto.MemberRequestDto;
import innosage.crm.member.dto.MemberResponseDto;
import innosage.crm.member.entity.Member;
import innosage.crm.member.mapper.MemberMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    private final MemberCommandAdapter memberCommandAdapter;
    private final MemberQueryAdapter memberQueryAdapter;
    private final RedisService redisService;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public MemberResponseDto.register register(MemberRequestDto.register request) {
        Member member = MemberMapper.toMember(request.getUserName(), request.getEmail(), encoder.encode(request.getPassword()), request.getPhoneNumber());
        Member savedMember = memberCommandAdapter.register(member);

        return MemberMapper.toRegister(savedMember);
    }

    @Transactional
    public MemberResponseDto.login login(MemberRequestDto.login request) {
        Member member = memberQueryAdapter.findByEmail(request.getEmail())
                .orElseThrow(() -> new MemberException(GlobalErrorCode.MEMBER_NOT_FOUND));
        TokenDto loginResponse = memberCommandAdapter.login(member, request.getEmail(), request.getPassword());

        return MemberMapper.toLogin(member, loginResponse.getAccessToken(), loginResponse.getRefreshToken());
    }

    @Transactional
    public MemberResponseDto.reissue reissue(MemberRequestDto.reissue request) {

        RefreshToken refreshToken = redisService.findRefreshToken(request.getRefreshToken()).orElseThrow(() -> new AuthException(GlobalErrorCode.REFRESH_TOKEN_EXPIRED));
        Member member = memberQueryAdapter.findById(refreshToken.getMemberId());
        TokenDto newToken = memberCommandAdapter.reissueToken(member, refreshToken);

        return MemberMapper.toReissue(newToken.getAccessToken(), newToken.getRefreshToken());
    }
}