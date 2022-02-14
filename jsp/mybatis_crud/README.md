

## JSP만으로 Mybatis 연결하고 CRUD 하기

- JSP 태그 사용법 익히기

- Mybatis 연동하기

- JS 로 적절한 방식의 응답 처리, 보여주기
	- form, ajax



### 테이블 구조


**MYPRODUCT**

Name     Null?    Type         
-------- -------- ------------ 
PRODID   NOT NULL VARCHAR2(10) 
PRODNAME NOT NULL VARCHAR2(20) 
PRICE    NOT NULL NUMBER(6)    
QUANTITY NOT NULL NUMBER(2)    



**기능**

- 전체 목록 조회

- 개별 상품 개수 수정

- 다중 상품 선택 삭제

- (js)상품 현황 수정 시 reload 없이 반영하기



