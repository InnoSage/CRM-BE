package innosage.crm.global.redis.service;

import innosage.crm.global.redis.entity.RefreshToken;
import innosage.crm.global.security.jwt.TokenProvider;
import innosage.crm.global.exception.common.GeneralException;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.member.entity.Member;
import innosage.crm.global.redis.repository.RefreshTokenRepository;
import innosage.crm.member.service.MemberQueryAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RedisService {

    private final MemberQueryAdapter memberQueryAdapter;

    private final RefreshTokenRepository refreshTokenRepository;

    private final TokenProvider tokenProvider;

    /**
     * 리프레시 토큰 발급
     * @param member
     * @return
     */
    public RefreshToken generateRefreshToken(Member member) {
        if (!memberQueryAdapter.existById(member.getId()))
            throw new GeneralException(GlobalErrorCode.MEMBER_NOT_FOUND);

        String refreshToken = tokenProvider.createRefreshToken();

        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .memberId(member.getId())
                        .refreshToken(refreshToken)
                        .build());
    }


    public RefreshToken reGenerateRefreshToken(Member member, RefreshToken refreshToken) {

        tokenProvider.validateRefreshToken(refreshToken.getRefreshToken());
        refreshTokenRepository.delete(refreshToken);

        String newRefreshToken = tokenProvider.createRefreshToken();

        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .memberId(member.getId())
                        .refreshToken(newRefreshToken)
                        .build());
    }


    public Optional<RefreshToken> findRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken);
    }
}
