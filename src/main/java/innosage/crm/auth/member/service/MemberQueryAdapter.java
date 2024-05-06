package innosage.crm.auth.member.service;

import innosage.crm.auth.member.entity.Member;
import innosage.crm.auth.member.repository.MemberRepository;
import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.member.MemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberQueryAdapter {

    private final MemberRepository memberRepository;

    public boolean existById(Long id) {
        return memberRepository.existsById(id);
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(()->new MemberException(GlobalErrorCode.MEMBER_NOT_FOUND));
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
