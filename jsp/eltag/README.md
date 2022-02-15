


### Expression Language

- 뷰에 자바 코드 사용을 지양하자는 마인드

- 자바코드 없이 속성 Key 값으로 데이터를 불러올 수 있다.

- 연산가능
	- ${KEY + 1}
- 비교가능
	- ${KEY > 10} 



**내장객체**

내장 객체란, 내부적으로 변수 선언과 초기화 작업이 자동으로 되는 객체로

개발자는 내장 객체를 사용할 때 참조변수의 이름을 기억하고 있다가 참조변수로 바로 접근하여 사용

EL에서도 JSP처럼 내장 객체를 지원하므로 필요한 객체는 내장 객체를 참조변수 이름으로 곧바로 사용 가능


- pageContext	 
	- JSP 내장 객체 pageContext와 같습니다.
- pageScope	 
	- pageContext에 등록된 데이터의 이름과 값을 저장하고 있는 map객체
- requestScope	 
	- HttpServletRequest에 등록된 데이터의 이름과 값을 저장하고 있는 map객체
- sessionScope	 
	- HttpSession에 등록된 데이터의 이름과 값을 저장하고 있는 map객체
- applicationScope	 
	- ServletContext에 등록된 데이터의 이름과 값을 저장하고 있는 map 객체
- param	 
	- QueryString의 이름과 값을 저장하고 있는 map객체
- paramValues	 
	- 같은 이름으로 전달된 질의 문자열의 이름과 값들을 저정하고 있는 map 객체
- header	 
	- 요청정보 헤더의 정보를 이름과 값으로 저장하고 있는 map객체
- headerValues	 
	- 요청정보 헤더의 정보들을 이름과 값들을 저장하고 있는 map객체
- cookie	 
	- 요청을 보낸 클라이언트의 쿠기 이름과 값을 저장하고 있는 map객체
- initParam	 
	- 웹 애플리케이션에 저장한 초기 파라미터의 이름과 값을 저장하고 있는 map 객체