


### Servlet Context

- Application 당 하나 생성
	- Application 객체
	- 여러 파일간 자원 공유
- 컨텍스트 파라미터
	- ServletContext 의 `getInitParameter(name)`;
- Read and Write;

```java
ServletContext context = getServletContext();
String param = context.getInitParameter("YourParam");
```


### Servlet Config

- 하나의 Servlet 에서 사용
	- Servlet 객체
- 초기화 파라미터
	- ServletConfig의 `getInitParameter(name)` 사용
	- 니가만든 서블릿은 Generic Servlet 을 상속받는 HttpServlet을 상속받는다
		- 니 서블릿 단에서 getInitParameter(name) 으로 호출
- Read Only



`interface Servlet, ServletConfig`=>`Abstract` GenericServlet => `Abstract HttpServlet` => 'Your Servlet'



<br>

### Scope

- 저장 + 변수처럼 lifecycle 을 가진다. 
- **Application Scope**
	- 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있다.
	 - ServletContext 인터페이스 구현한 객체 사용
		- getServletContext()
		- 애플리케이션과 라이프사이클이 같다.
		- 웹 컨테이너에서 종료하지 않는 이상 살아있다.
	- 모든 클라이언트가 공통적으로 사용해야할 값

- **Session Scope**
	- 웹 브라우저(클라이언트) 별로 변수를 관리하고자 할 경우 사용한다.
		- 한 클라이언트에 대한 여러 요청을 모두 커버
	- Request 보다 상태정보를 더 유지한다.
	- HttpSession 인터페이스 구현한 객체 사용
		- request.getSession()
		- **같은** 브라우저단과 라이프사이클이 동일하다
		- 이론적으로는 브라우저와 동일한 주기를 가지나 보안 문제로 timeout을 주어 사용함
	- 인증, 장바구니같은 클라이언트별 처리

- **Request Scope**
	- Web container 안에 있는 Servlet에 대한 http 요청을, WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용한다
	- HttpServletRequest
		- doGet  or doPost 의 파라미터 변수
		- 요청=> 응답 후 사라짐

- Page Scope

- 저장,조회 기능
	- setAttribute
	- getAttribute




**save**

```java
        //1. Application Scope 에 저장
        // servletContext 가져오기
        ServletContext application = getServletContext();
        // 저장
        application.setAttribute("application", "App");

        //2. Session Scope
        // session 가져오기
        HttpSession session = request.getSession();
        // 저장
        session.setAttribute("session", "Session");

        //3. Request Scope
        // 저장
        request.setAttribute("request", "Req");

        System.out.println("Scope Save Success!");
```


**load**

```java
        // 1. Application scope 데이터 조회
        ServletContext application = getServletContext();
        String applicationResult = (String) application.getAttribute("application");

        // 2. Session scope 데이터 조회
        HttpSession session = request.getSession();
        String sessionResult = (String) session.getAttribute("session");

        // 3. Request scope 데이터 조회
        String requestResult = (String) request.getAttribute("request");

        // 애플리케이션 단에서 생명주기를 가진다.
        System.out.println("Application Scope : " + applicationResult);
        // 같은 브라우저 내에서 생명주기가 동일하다.
        System.out.println("Session Scope : " + sessionResult);
        // 하나의 요청에 대해서만 생명주기를 가지기 때문에 값을 가져올 수 없다.
        System.out.println("Request Scope : " + requestResult);
```




### servlet with JDBC

- Standalone
	- Main<->Service<->DAO <-> DB
	- jdbc 구현라이브러리 jar => build Path에 추가

- Web
	- Servlet <-> Service <-> DAO <-> DB
	- 실행부 없음
		- 브라우저를 통해 URL 로 요청하면 적절한 서블릿이 응답
	- WEB-INF > lib 에 등록


	