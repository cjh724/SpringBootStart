package hello.springbootstart;

import hello.springbootstart.repository.JpaMemberRepository;
import hello.springbootstart.repository.MemberRepository;
import hello.springbootstart.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
//    private final DataSource dataSource;

//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    @Autowired
    private EntityManager entityManager;

    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(entityManager);
    }
}
