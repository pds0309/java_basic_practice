


### 세션관리

- Http 프로토콜의 특징 때문에 세션관리가 필요하다.

Http의 특징
- Stateless and Connectionless

**Stateless**

- 브라우저의 요청에 대해 서버가 응답을 하고 난뒤에 어떻게 될까?
	- 상태가 끊어진다. 
		- 부하 방지

> 장바구니를 예를 들어보자. 니가 물건을 골라서 장바구니에 넣었는데 결제 페이지로 와도 유지된다. 하지만 기존 http 프토토콜만으로는 이는 불가능하다.
A(쇼핑) 페이지에서 했던 작업을 B(구매) 페이지는 기본적으로는 모른다. 응답 후 상태가 없어지기 때문에.



**세션관리 방법**

- HttpSession and Cookie
	- session 
		- 서버에 저장하는 것
	- cookie 
		- 클라이언트에 저장하는 것


- HttpSession 이라는 API 를 이용한다.
	- 웹 브라우저와 동일한 LifeCycle 을 가짐
		- => 무상태성으로 다른 페이지에 데이터 전달이 불가능한 현상을 해결해 줄 수 있음
		- 일종의 웹 컨테이너의 저장소 개념
			- 이 저장소(HttpSession)를 얻어와 사용함(세션얻기)
	- HttpSession
		- Key and Value
	- 대략적인 과정
		- 1. 클라이언트가 브라우저로 요청한다.
		- 2. 적절한 서블릿이 실행됨
		- 3. 서블릿에서 요청에 대한 응답 데이터 얻음
		- 4. 세션을 Request 로부터 얻어온다.(저장소 얻기)
			- `HttpSession session = request.getSession();`
			- `HttpSession session = request.getSession(boolean)`; 
				- true(default)
					- 있으면 있는걸, HttpSession 이 없으면 생성해서라도 반환한다.
					- 데이터 저장 측에서 사용
				- false
					- 있으면 있는걸, 없으면 null 반환
					- 사용 측에서 사용할 수 있나 일반적으로 사용 X
		- 5. 세션에 값 저장
			- session.setAttribute("key", value);
		- 6. 응답처리 => 응답
		- 7. 같은 브라우저의 클라이언트에서 다른 서블릿으로의 요청
		- 8. 적절한 서블릿 실행
		- 9. 세션을 얻어온다.
			- request.getSession();
			- key 값으로 세션 valid check
				- session.getAttribute("key") ? null ;
				- 특정 작업에 대해 세션 비유효시 다른 페이지로 리다이렉트 하는 등의 처리 가능
		- 10. 세션 유효에 따라 적절한 처리 응답하기
	- 메소드
		- session.removeAttribute(key)
			- 키에대한 세션만 삭제
		- session.invalidate();
			- 세션 전체를 무효화


