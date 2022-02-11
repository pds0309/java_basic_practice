



## JSP (JavaServer Pages)



> 자바 서버 페이지는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 서버 사이드 스크립트 언어이다. 


- JSP 는 실행 시 Servlet으로 변환된 후 실행된다.
- 서블릿과 달리 HTML 표준에 맞게 작성되기 때문에 웹 디자인에는 편리하다.
- JSTL 등 JSP 태그 라이브러리를 사용하면 자바코딩 없이 태그만으로 기술 작성 가능


### 동작
	- 1.  클라이언트의 요청에 대해서 웹 컨테이너의 JSP 가 응답한다.
	- 2. JSP 를 `Servlet(*.java)` 로 변환한다.
	- 3. *.class 컴파일후 생성됨(최초한정)
		- jsp_init 호출됨
	- 4. 서비스 실행
		- `jspService` method 
			- Param: request, response 
		- 요청처리
		- DB 연동
		- 응답처리
			-html 태그로 구성되어있어 명시적 html 작성 필요 X
	- 5. 결과 (html) 응답
	- 최초 요청 시 응답 느림



### 서블릿에서는 어땠을까?

	- 1. 클라이언트 요청에 대해 서블릿이 응답한다.
	- 2. 서블릿이 생성된다.(init)
	- 3. 서비스 실행
		- doGet, doPost
			- param: HttpRequest, HttpResponse
		- 요청처리
		- DB 연동
		- 응답처리
	- 4. 결과 (html) 응답
	


### JSP 태그


- "<@ %>"
	- jsp 전용 태그

- 자체가 태그로 되어있어 응답페이지 처리가 쉬움


**directive 태그**
	- <%@ page 속성="값" %>
		- contenttype : 한글처리
		- import : 자바 라이브러리
	- <%@ include file="*.jsp" %>
	- <%@ taglib prefix="" %>

**declaration 태그**
	- <%! %>
		- Servlet의 인스턴스 변수 or 메소드 포지션


**scriptlet 태그**
	- <% %>
		- Servlet의 서비스(doGet, doPost) 메소드 영역


**expression 태그**
	- <%= var %>
		- 변수
	- 브라우저에 출력이 된다.




### JSP로 요청처리 EX) 로그인 요청처리

- 1. 클라이언트가 로그인을 위해 LoginForm(로그인 시도 페이지) 을 요청하면 응답함.
- 2. 클라이언트가 양식을 제출하여 로그인을 POST 요청
	- 3-1) Servlet
		- doPost 메서드에서 HttpServletRequest 로 부터 입력정보, 세션 등을 얻어옴
	- 3-2) **JSP**
		- 요청에 대한 메소드와 request , response 없음?
		- 자동으로 처리되는 것이다.
		- **내장객체,내장변수**
			- JSP 에서 선언 없이 사용가능한 객체
			- 내부적으로 알아서 필요한 객체, 변수 선언해줌
			- JSP 가 `.java` 로 변경될 때 미리 선언되어 있고 반드시 존재
			- **내장변수 - Type**
				- `request` : HttpServletRequest
				- `response` : HttpServletResponse
				- `application` : **ServletContext**
				- `config` : **ServletConfig**
				- `out` : (JSP)PrintWriter
				- `session` : HttpSession
		- 어차피 JSP 는 요청 시 내부적으로 `.java` Servlet 으로 변형되기 때문에 다 쓸 수 있다고 이해했다.






### JSP vs Servlet

**JSP**
	- 화면 처리에 특화

**Servlet**
	- 비즈니스 로직에 특화


**Servlet + JSP 환경에서 Web App 개발패턴**

- Model1 Arc
	- 뷰+로직
	- JSP 로 개발 => 매우 빠르게 개발 가능
		- 유지보수가 꾸짐
	- JSP <-> Service <-> DAO
- Model2 Arc
	- 뷰, 로직 분리
	- Servlet + JSP
	- 요청을 Servlet 에서 받아 뷰에 적절한 처리는 JSP 로 위임
	- `Controller` 역할인 Servlet 은 `Model`(Service & Data) 와 jsp 인 `View` 와 연결됨
