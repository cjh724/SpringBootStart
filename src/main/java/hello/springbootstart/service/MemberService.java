package hello.springbootstart.service;

import hello.springbootstart.domain.Member;
import hello.springbootstart.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        // new 를 통해서 생성하는게 아니라 외부에서 넣어주도록 변경 : DI ( Dependency Injection ) -> 생성자 주입 권장 ( 필드 주입, setter 주입 지양 )
        this.memberRepository = memberRepository;
    }

    public Long join ( Member member) {     // 회원가입
        validateDuplicateMember(member);    // 같은 이름이 있는 회원은 가입 불가

        memberRepository.save( member );
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {         // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
