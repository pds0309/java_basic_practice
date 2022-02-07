
### Servlet


- 서블릿은 자바로 웹페이지를 **동적**으로 생성하는 서버 프로그램
- 자바 클래스의 일종임
- 톰캣 웹 컨테이너에 의해 서블릿의 모든 라이프사이클이 관리됨
- 자바 웹 환경에서는 main 메소드(시작점) 이 없음
	- Client 의 요청에 맞는 적절한 서블릿이 시작점이 됨


<br>


**서블릿 작동에 필요한 것**

- HttpServlet 상속
	- 일반 클래스와 달리 웹브라우저와 요청응답이 가능하게 해줌
- doGet, doPost 등의 메소드
	- 적절한 요청에 맞는 메소드
- tomcat에 servlet 등록하면서 servlet mapping 하는 과정
	- web.xml 또는 @WebServlet Annotation 사용해 등록한다.
	- 경로



**서블릿 요청 방법**

- http://IP/Context/servlet/경로를모두포함한니가만든서블릿
	- 보안에 취약
		- 서블릿인거 개나소나 다알게됨
	- 너무 김
	- ServletMapping(url mapping) 필요
		- /servlet/경로를모두포함한니가만든서블릿 => 별칭 주는 것


**Request Response**

- 역할
	- 비즈니스로직처리
		- DB연동
		- 클라이언트로부터 전달된 파라미터 처리
	- html 생성 후 응답


- 응답처리
	- HttpServletResponse
	- 브라우저에게 처리할 Data Type 알려줌 (MIME) type
	- 자바 I/O API 사용해 html을 출력해줌	
- 요청처리
	- HttpServletRequest
	- 브라우저가 요청한걸 얻어오는 것
	- reqeust.getParameter => 클라이언트 측  name 에 대한 하나의 값
	- request.getParameterValues => name 에 대한 여러 값


