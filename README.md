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

---
단축키
1. Command + N
   - Getter/Setter
2. Command + P ( 어노테이션에 커서 둔 다음 )
   - 어노테이션 도움말
3. Command + Shift + Enter ( 세미콜론 자동완성 )
   - 자동완성
4. Option + Enter ( Editor 의 빨간줄 커서 둔 상태 )
   - import
5. Control + Enter ( ex. Java, Generate 등 )
   - 신규파일 생성

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