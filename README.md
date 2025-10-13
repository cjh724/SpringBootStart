.idea(폴더) : Intellij 가 사용하는 설정파일

---
로그 관런 라이브러리 : logback, slf4j

---
스프링시작 : 메뉴얼 검색
1. https://spring.io/
2. project > spring boot
3. learn > reference doc.

---
서버 자동 재시작 ( 확인중... )
1. 의존성(dependency) 추가  
   1) build.gradle 에 추가  
   implementation 'org.springframework.boot:spring-boot-devtools'
2. IntelliJ 설정 ( IntelliJ IDEA > Settings...)
   1) Build, Execution, Deployment 클릭
   2) Compiler 클릭
   3) Build project automatically 체크
   4) Advanced Settings 클릭
   5) Allow auto-make to start even if developed application is currently running 체크
   6) gradle 새로고침 클릭

---
스프링 웹개발
1. 정적 컨텐츠
   1) http://localhost:8080/hello-static.html 
2. MVC와 템플릿엔진 ex. jsp
   1) http://localhost:8080/hello-mvc?name=spring
3. API ( @ResponseBody )
   1) http://localhost:8080/hello-string?name=abcde -> 문자열 리턴 ( hello abcde )
   2) http://localhost:8080/hello-api?name=qwer -> JSON 리턴 ( {"name":"qwer"} )

---
어노테이션
1. @ResponseBody : ViewResolver를 사용 안하고 HTTP의 BODY에 HttpMessageConverter 반환
   1) 기본 문자처리 : StringHttpMessageConverter
   2) 기본 객체처리 : MappingJackson2HttpMessageConverter
   3) byte 처리 등 기타 여러 HttpMessageConverter 가 기본으로 등록되어 있음
2. @AfterEach
   1) JUnit 에서 각 테스트가 종료할 때마다 실행 ( 테스트별 의존성 제거 )
3. @BeforeEach
   1) JUnit 에서 각 테스트 실행 전에 호출됨
   2) 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계로 새로 맺어줌
4. @Configuration
   1) 스프링 빈 등록할 때 사용

---
스프링 빈 등록 방법
1. 컴포넌트 스캔과 자동 의존관계 설정
   1) @Controller, @Service, @Repository 에 @Component 가 존재
   2) @Component 가 있으면 스프링 빈으로 자동 등록됨
   3) 생성자에 @Autowired 사용 <br>
      (1) 스프링이 객체생성 시점에 연관된 객체를 스프링 컨테이너에서 해당 스프링 빈을 찾아서 주입함 <br>
      (2) 생성자가 1개만 있으면 생략 가능 <br>
      (3) DI ( Dependency Injection, 의존성 주입 ) : 객체 의존관계를 외부에서 넣어주는 것
   4) 컴포넌트 기본 스캔 대상 <br>
      (1) 최초 실행되는 SpringbootStartApplication 가 속해 있는 hello.springbootstart 패키지랑 동일한 패키지거나 하위 패키지는 스프링 빈으로 자동 등록 <br>
      (2) @SpringBootApplication 에 들어가보면 @ComponentScan 이 존재함.
   5) 사용목적 : 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용
2. 자바코드로 직접 스프링 빈 등록
   1) 사용목적 : 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록

---
참고
1. 스프링은 스프링 컨테이너에서 스프링 빈을 등록할 때 기본으로 싱글톤으로 등록 <br>
   즉, 같은 스프링 빈이면 모두 같은 인스턴스 ( 대부분 )

---
IntelliJ 단축키
1. Command + N
   - Getter/Setter
2. Command + P ( 어노테이션, 파라미터에 커서 둔 다음 )
   - 도움말
3. Command + Shift + T
   - JUnit 파일 신규 생성 ( 해당 자바파일에서 단축키 수행 )
4. Command + Shift + Enter
   - 자동완성 ( ex. 세미콜론, 줄바꿈 등 )
5. Command + Shift + ( '[' or ']' )
    - Editor 탭이동
6. Command + Shift + 8
   - 세로(컬럼) 편집 켜기, 한번 더 누르면 끔
7. Command + Option + v
   - 객체/변수 자동완성
8. Control + Enter ( ex. Java, Generate 등 )
   - 신규파일 생성
9. Control + Command + F
   - 전체화면
10. Control + Shift + R
    - JUnit 에서 TestCase 실행
11. Control + T
    - 함수로 빼기 : 블럭한 후 Control + T -> Extract Method 선택
12. Control + R
    - JUnit 에서 이전에 TestCase 수행했던 것 재수행
13. Option + Enter
    - import
    - static import 가 되고, Assertions.assertThat -> assertThat 만 쓸 수 있음

---
자바 : Stream API(filter 메소드), Lambda, Optional
1. Stream
   1) Java 8 부터 사용
   2) Collection이나 Array 등의 데이터를 함수형 방식으로 처리할 수 있게 하는 추상화된 데이터 시퀀스
2. filter
   1) Java 8 부터 사용
   2) Stream의 중간 연산 중 하나로, 주어진 조건(Predicate)을 만족하는 요소만 걸러내어 새로운 Stream을 생성하는 데 사용
   3) 예시 : findByName ( MemoryMemberRepository.java )
3. Optional
   1) Java 8 부터 사용
   2) null인 값을 참조해도 NullPointerException이 발생하지 않도록 값을 감싸는 Wrapper 클래스
   3) value에 값을 저장하기 때문에 값이 null이더라도 바로 NPE가 발생하지 않음
   4) 클래스이기 때문에 각종 메소드 제공
   5) 예시 : findById ( MemoryMemberRepository.java )