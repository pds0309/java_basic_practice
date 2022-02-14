<%@ page import="com.service.ProductServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-11
  Time: 오후 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 단일 삭제</title>
</head>
<body>
<%
    String requestedId = request.getParameter("reqid");
    int status = new ProductServiceImpl().deleteOneById(requestedId);
%>
<%
    if (status == 1) {
%>
<h3><%= requestedId + " 상품삭제 성공" %>
</h3>
<a href="listProduct.jsp">목록보기</a>
<%
        return;
    }
%>
<%= "이미 존재하지 않는 상품이거나 잘못된 요청으로 상품삭제 실패" %>
<br>
<a href="listProduct.jsp">목록보기</a>
</body>
</html>
