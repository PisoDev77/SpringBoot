# Learning Spring

## 인프런 김영한님의 스프링 강의
#### 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술
영한님의 스프링 강의를 보면서 스프링을 다시 들여다 보자.

start.spring.io에서  프로젝트를 설정해서 다운로드 받고 IntelliJ에 Import 하는 방법은 꽤나 충격이었다.
그전에는 온갖 똥꼬쇼를 하면서 legacy 선택하고 이클립스로 이리저리 했던 것을 그냥 다운로드 했던것이다. 놀랍네..

또 놀라운 것은 빌드 후 배포였다.. 카페24로 톰캣설치하고 아파치 설정하고 막 오버했던 내자신이 허망해진다. 빌드하고 그저 자바를 실행해주면 아름답게 실행되는 이 스프링 내일 공부중인 
스프링 입문강의에 대한 내용을 서버에 빌드 후 열어봐야겠다..

- 1
  - 요즘은 Gradle 많이쓴다. 전에는 Maven 이였다.
  - 구조에서는 main 밑에 자바 코드가 있다.
  - test밑에는 테스트코드를 위해
  - build.gradle 중요하다.
  - SPRING BOOT  는 내장톰캣이 있다. (아... 진짜 과거에 고생했는데...)
  - External Libraries 보면 이것저것 다 땡겨온다. 의존들을 관리해주는 곳이다.
  - 로그가 중요하다 현업은 꼭 로그로 출력해야한다. 로그로 남겨야하기때문
    시스템아웃엘엔좀그렇다./
  - logback | slf4j  요즘은 로그백을 선택합니다 속도도 빠르고해서 test junit 라이브러리 5로 넘어가는 추세
- 2
  - 웹 진입점에 첫번쨰 CONTORLLER localhost:8080/hello 던져 SPRING이 헬로우컨테이너에서 확인함 GetMapping Model 에다가 sprint-boot-devtools 서버 재시작없이 사용가능 검색해보자 자 이제 빌드하고 실행해보자 와 이거 너무 편하다.
- 3
  - 정적 페이지 그냥 던져줘 static 밑에 
  - MVC template 
  - API --@RESPONSEBODY
- 4
  - 가상의 시나리오
  - 서비스 핵심 로직 들어가있음
  - 도메인 회원 주문 쿠폰 등 비즈니스 객체 
  - MemberService MemberRepository -< interface로 왜 아직 정해지지않음
  - 