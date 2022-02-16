




## JSTL (JSP Standard Tag Library)

- JSP 에서 자바코드 대신 태그를 사용하도록 만든 라이브러리

- 커스텀태그를 활용하는 거임

- 커스텀태그들 중 Standard가 된 Apache 에서 제공해주는 태그들을 말함
	- `jstl.jar` Apache에서 다운받아 사용


<br>


### 사용

- 적절한 버전의 라이브러리 의존성을 등록한다. [apahce](https://jakarta.apache.org/)


### 태그 라이브러리 선언

- 자바에서 import 하듯 JSP 에서 JSTL을 사용하기 위해서 선언이 필요함


```html
<%@ taglib prefix="?" uri="URI" %>
```


#### taglib prefix 룰


|Taglib|선언|
|----------|---------------------------------------------------------------------------|
|Core|	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>|
|XML|	<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>|
|I18N|	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>|
|Database	|<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>|
|Functions|	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>|



### 주요 문법 - Core

```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

**변수 설정**

```
<c:set var="xxx" value=""></c:set>

```

**변수 출력**

```
<c:out value="${xxx}"></c:out>
```

**IF**

```
<h2>IF</h2>
<c:if test="${username=='김갑환'}">
    갑환이 어서와~
</c:if>
```


**choose => (when,otherwise)**

```
<h2>Choose</h2>
<c:choose>
<c:when test="${age > 50}">늙었어</c:when>
<c:when test="${age > 30}">딱좋아</c:when>
<c:when test="${age > 10}">햇병아리야</c:when>
<c:otherwise>응애!</c:otherwise>
</c:choose>

```



**For Loop - basic**


```
<c:forEach var="i" begin="1" end="15" step="2">
    ${i}<br>
</c:forEach>
```



**For Loop - Object**

```
<c:forEach var="person" items="${list}" varStatus="status">
    ${status.count} <br>
    ${person.name},${person.age}<br>
</c:forEach>
```


**For token**

```
<c:forTokens var="xxx" items="${tokens}" delims="/">
    ${xxx}<br>
</c:forTokens>

```







