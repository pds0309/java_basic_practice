


### Filter API

- 브라우저의 요청에 대해 서블릿이 요청을 받기 전
- 서블릿이 응답을 브라우저에 주기 전 동작하는 어떤 작업을 Filter 라고 한다.
- 필터와 서블릿은 체인으로 묶임
- 요청필터 예시 
	- 한글처리, 로깅
- 응답필터 예시 
	- 응답 형식 포맷변경, 압축해서 응답 
- 공통적인 기능들을 서블릿이 호출되기 전에 수행(전처리)되게 하고 싶거나 서블릿이 호출 되고 난 뒤에 수행(후처리) 하고 싶으면 공통적인 기능들을 서블릿 필터로 구현하면 된다.
- Servlet은 HTTPServletRequest였다면 Filter는 ServletRequest이다.
	- ServletRequest 가 더 부모클래스이다.


**구현하기**

- Filter implements
	- 메소드 재정의
- 필터를 Servlet 처럼 등록해줘야 톰캣이 알 수 있다.
	- Annotation 방식 등록
	- Web.xml 등록
- 필터클래스를 만들고 doFilter 로 필터작업을 한다.
	- 반드시 chain 에 연결해줘야한다.

- URL pattern 을 지정하여 해당 URL 에 대해 동작하게끔 만든다.


```xml

<url-pattern> /hello</url-pattern>
<url-pattern> /*</url-pattern>
```

- ip:port/context 명 뒤의 경로를 기준으로 함




**filter interface**

-객체 
	- FilterConfig
	- FilterChain
	- Filter
- 메소드
	- doFilter(req , rep)
		- request, response
			- HttpServlet 보다 부모인 ServletRequest, ServletResponse 를 파라미터로 받음
		- doFilter() 의 뒤에 요청에 대한 서블릿이 있다.
	- doFilter 전후로 생각해보기
		- doFilter Line 전
			- 요청필터 작업영역
			- 요청에 대해 먼저 처리할 작업에 대해 작성
		- doFilter Line 후
			- 요청에 대한 서블릿이 돌아온 상태
			- 응답에 대해 처리할 작업을 작성
	- 필터는 한번만 수행되지 않고 요청을 받을 때 마다 수행됨
		- 하나의 필터를 수행하고 난 뒤 chain.doFilter() 메소드를 통해 다음 부분으로 넘겨줌


**Filter의 라이프 사이클**

- 필터는 서블릿과 비슷한 라이프사이클을 가지며 생성, 초기화, 필터, 종료의 4단계로 이루어짐

- 서블릿 컨테이너는 필터 객체가 초기화 파라미터에 접근하는데 사용하는 환경설정 객체(FilterConfig)의 레퍼런스를 제공한다. 
- 서블릿 컨테이너가 필터의 init() 메소드를 호출하면 필터 인터페이스는 바로 요청을 처리할 수 있는 상태가 된다.
- 서블릿이 service() 메소드를 이용해서 요청을 처리한 것 처럼 필터는 doFilter() 메소드를 통해서 요청을 처리한다. 
- 모든 요청에 대한 처리가 끝나면 destroy() 메소드가 호출되면서 필터는 비활성 상태로 변경된다.


**FilterChain**

- 필터는 연속적인 작용을 수행함 
- 필터 객체가 수행해야 할 부분인 doFilter() 메소드로 인자로 전달되는 것이 FilterChain 객체
- FilterChain 객체는 필터의 수행과정을 연속적으로 하기 위한 방법 
- 웹 컨테이너가 FIlterConfig 객체와 함께 FilterChain 인터페이스를 구현한 객체를 생성한다.




[ref](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=adamdoha&logNo=221665607853)



 
