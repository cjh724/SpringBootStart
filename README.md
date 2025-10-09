폴더 : .idea : Intellij 가 사용하는 설정파일

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
3. API
   1) http://localhost:8080/hello-string?name=abcde -> 문자열 리턴 ( hello abcde )
   2) http://localhost:8080/hello-api?name=qwer -> JSON 리턴 ( {"name":"qwer"} )
   3) @ResponseBody

---
어노테이션
1. @ResponseBody : ViewResolver를 사용 안하고 HTTP의 BODY에 HttpMessageConverter 반환
   1) 기본 문자처리 : StringHttpMessageConverter
   2) 기본 객체처리 : MappingJackson2HttpMessageConverter
   3) byte 처리 등 기타 여러 HttpMessageConverter 가 기본으로 등록되어 있음

---
단축키
1. Getter/Setter : Command + N
2. 어노테이션 도움말 : Command + P ( 어노테이션에 커서 둔 다음 )
3. 자동완성 : Command + Shift + Enter ( 세미콜론 자동완성 )