package innosage.crm.member.repository;

import innosage.crm.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email); //이메일로 Member 찾기
    boolean existsByEmail(String email); //이메일로 Member 존재 여부 확인

}