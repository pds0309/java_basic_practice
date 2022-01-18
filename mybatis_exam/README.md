
## Mybatis Practice

---


### 2개의 xml 이 필요하다


1. DB 설정정보
    - configuration.xml
    
2. SQL 저장 -> Mapper 파일
    - TB 당 한개씩 만들어짐
        - ex) DeptMapper.xml
    

--- 

### 설정하기

* Configuration.xml
    - ${key} -> value
    - `.properties` 확장자에 Key-Value 매칭
        - 한글이 안나와요!
            - properties => 인코딩을 UTF-8
        - 사용법
            - Key = Value
            - 공백 주의하라
    
* mapper.xml
    - \#{var} => sql 바인딩 변수





### Mybatis vs JDBC

- jdbc
    - `.java` 내부에서 모든 프로세스 처리됨
        - DB설정
        - 쿼리문 선언실행 등
    - DB관련 변경에 민감하다.
        - 쿼리,DB 변경시 프로젝트를 재컴파일해야된다.
    
- mybatis
    - DB 연결정보 및 쿼리를 외부파일화 함
        - xml , properties



### 연동하기

- configuration.xml -> 자바단에서 인식시켜줘야함.

- **example**

```java
String resource = "org/mybatis/example/mybatis-config.xml";
InputStream inputStream = Resources.getResourceAsStream(resource);
SqlSessionFactory sqlSessionFactory =
 new SqlSessionFactoryBuilder().build(inputStream);
```

- SqlSessionFactory
    - `.openSession();`
        - 세션 얻어오기
    
- SqlSession
    - 사용
    - ```java // 사용예시
         session.insert(String id)
         session.insert(String id , Object obj)
      ```



**MyBatis - org.apache.ibatis.executor.ExecutorException: Executor was closed.**

MyBatis에서 SqlSession을 SqlSessionFactory에서 openSession후 close를 하면

`org.apache.ibatis.executor.ExecutorException: Executor was closed.`

와 같은 오류가 생길 수 있다.

이는 SqlSession의 인스턴스는 공유되지 않기 때문에

close후 새로 생성해서 사용해야 한다.

또한 SqlSession을 static 필드나 클래스의 인스턴스 필드로 지정해서는 안된다. 
