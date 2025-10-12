package hello.springbootstart.repository;

import hello.springbootstart.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("springboot");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();

        // 확인1 : 정상
        System.out.println("result = " + result + " : " + member + " || " + (member == result));

        // 확인2 : 정상
        // Assertions.assertEquals(member, result);        // import org.junit.jupiter.api.Assertions;

        // 확인3 : 오류
        // Assertions.assertEquals(member, null);

        // 확인4 : 정상 -> 이걸로 검증하자
        Assertions.assertThat(member).isEqualTo(result);    // import org.assertj.core.api.Assertions;

        // 확인5 : 오류
        // Assertions.assertThat(member).isEqualTo(null);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("springboot1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("springboot2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("springboot1").get();
        // 확인1 : 정상
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("springboot1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("springboot2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();
        // 확인1 : 정상
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
