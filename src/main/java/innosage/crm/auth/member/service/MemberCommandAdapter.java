package innosage.crm.auth.member.service;

import innosage.crm.auth.member.entity.Authority;
import innosage.crm.auth.member.entity.Member;
import innosage.crm.auth.member.repository.MemberRepository;
import innosage.crm.global.redis.entity.RefreshToken;
import innosage.crm.global.security.jwt.TokenDto;
import innosage.crm.global.security.jwt.TokenProvider;
import innosage.crm.global.redis.service.RedisService;
import innosage.crm.global.redis.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemberCommandAdapter {

    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final RedisService redisService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public Member register(Member member) {
        return memberRepository.save(member);
    }

    public TokenDto login(Member member, String email, String password) {

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.createAccessToken(member, List.of(new SimpleGrantedAuthority(Authority.ROLE_USER.name())));
        String refreshToken = redisService.generateRefreshToken(member).getRefreshToken();

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public TokenDto reissueToken(Member member, RefreshToken refreshToken){

        String accessToken = tokenProvider.createAccessToken(member, List.of(new SimpleGrantedAuthority(Authority.ROLE_USER.name())));
        RefreshToken newRefreshToken = redisService.reGenerateRefreshToken(member, refreshToken);

        return TokenDto.builder()
                .accessToken(accessToken)
                .refreshToken(newRefreshToken.getRefreshToken())
                .build();
    }
}
