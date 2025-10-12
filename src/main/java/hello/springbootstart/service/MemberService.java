package hello.springbootstart.service;

import hello.springbootstart.domain.Member;
import hello.springbootstart.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemoryMemberRepository memoryMemberRepository =  new MemoryMemberRepository();

    public Long join ( Member member) {     // 회원가입
        validateDuplicateMember(member);    // 같은 이름이 있는 회원은 가입 불가

        memoryMemberRepository.save( member );
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memoryMemberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    public List<Member> findMembers() {         // 전체 회원 조회
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memoryMemberRepository.findById(memberId);
    }
}
