package hello.springbootstart.repository;

import hello.springbootstart.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long,Member> store = new HashMap<>();    // DB 가 아닌 메모리에 저장
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));      // null 출력 방지
    }

    @Override
    public Optional<Member> findByName(String name) {
        // loop + 람다
        return store.values().stream()
                .filter(member -> member.getName().equals(name))        // 같은것만 필터
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
