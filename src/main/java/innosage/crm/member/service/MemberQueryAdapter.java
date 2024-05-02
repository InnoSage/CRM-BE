package innosage.crm.member.service;

import innosage.crm.global.exception.common.code.GlobalErrorCode;
import innosage.crm.global.exception.member.MemberException;
import innosage.crm.member.entity.Member;
import innosage.crm.member.repository.MemberRepository;
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
