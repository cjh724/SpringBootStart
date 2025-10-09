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
3. API

---