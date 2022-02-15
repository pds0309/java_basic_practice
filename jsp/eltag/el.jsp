<%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-15
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>EL 방식</h1>
<p>값: ${request}</p>
<h1>DTO 가져오기</h1>
${requestdto}
${requestdto.getName()}
${requestdto.age}

<h1>컬렉션가져오기</h1>
${requestlist}<br>
${requestlist[1]}<br>
${requestlist[1].getName()}

<h1>세션스코프 가져오기</h1>
${sessionScope.session}
<h1>애플리케이션 스코프 가져오기</h1>
${applicationScope.app}
</body>

<h1>조건</h1>
<h3>
    ${requestdto.getName()} 는
    ${requestdto.getAge() < 25 ? "애기라 안대여~" : "다컸네요!"}
</h3>
<h1>없는 키는 어떻게 나와요</h1>
<h3>없는키는공백:</h3>${iloveyou}
<h3>없는키는비교가?:</h3>${empty iloveyou}
</html>
