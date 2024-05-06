package innosage.crm.member.mapper;

import innosage.crm.member.dto.MemberResponseDto;
import innosage.crm.member.entity.Authority;
import innosage.crm.member.entity.Member;
import innosage.crm.member.entity.MemberStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//DTO 변환 클래스
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMapper {

    public static Member toMember(String username, String email, String password, String phoneNumber) {
        return Member.builder()
                .username(username)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .authority(Authority.ROLE_USER)
                .status(MemberStatus.ACTIVE)
                .build();
    }

    public static MemberResponseDto.register toRegister(Member member) {
        return MemberResponseDto.register.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

    public static MemberResponseDto.login toLogin(Member member, String accessToken, String refreshToken) {
        return MemberResponseDto.login.builder()
                .userId(member.getId())
                .username(member.getUsername())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public static MemberResponseDto.reissue toReissue(String accessToken, String refreshToken) {
        return MemberResponseDto.reissue.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
}
