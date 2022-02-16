<%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-16
  Time: 오전 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL 문법</title>
</head>
<body>
<h2>EL 방법</h2>
<h3>이름:${username}</h3>
<h2>JSTL 방법</h2>
<c:set var="xxx" value="${username}"></c:set>
이름2:${xxx}<br>
이름3:<c:out value="${username}"></c:out>
이름4:<c:out value="${xxx}"></c:out>
<br>
<h2>IF</h2>
<c:if test="${username=='김갑환'}">
    갑환이 어서와~
</c:if>
<br>
<h2>Choose</h2>
<c:choose>
    <c:when test="${age > 50}">늙었어</c:when>
    <c:when test="${age > 30}">딱좋아</c:when>
    <c:when test="${age > 10}">햇병아리야</c:when>
    <c:otherwise>응애!</c:otherwise>
</c:choose>
<br>
<h2>For - basic</h2>
<c:forEach var="i" begin="1" end="15" step="2">
    ${i}<br>
</c:forEach>
<h2>For - object</h2>
<c:forEach var="person" items="${list}">
    ${person.name},${person.age}<br>
</c:forEach>
<h3>For - object get Index</h3>
<c:forEach var="person" items="${list}" varStatus="status">
    ${status.count} <br>
    ${person.name},${person.age}<br>
</c:forEach>

<h2>For</h2>
<c:forEach var="person2" items="${list}" varStatus="status">
    ${status.index}:${person2.name},${person2.age}::::${status.count}::::${status.first}:::${status.last}<br>
</c:forEach>

<h1>forToken</h1>
<c:forTokens var="xxx" items="${tokens}" delims="/">
    ${xxx}<br>
</c:forTokens>

<br>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>FMT</h3>
<fmt:formatNumber value="123456789" type="currency"/>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3>Function</h3>
문자열값:${str}<br>
문자열길이:${fn:length(str)}<br>
문자열대문자:${fn:toUpperCase(str)}<br>
문자열소문자:${fn:toLowerCase(str)}<br>

부분열:${fn:substring(str2, 0, 6)}<br>

공백제거:${fn:trim(str3)}<br>

포함여부:${fn:contains(str3, "홍")}<br>
포함여부:${fn:contains(str3, "박")}<br>

값변경:${fn:replace(str3, "홍","박")}<br>

split:${fn:split(str4, "/")[0]}<br>
split:${fn:split(str4, "/")[1]}<br>

</body>
</html>
