<%@ page import="com.service.ProductServiceImpl" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-11
  Time: 오후 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String result = request.getParameter("reqidlistresult");
    System.out.println(result);
    List<String> resultList = Arrays.asList(result.split(","));
    System.out.println(resultList.size());
    int status = new ProductServiceImpl().deleteByIdIn(resultList);
%>
<%
    if (status != 0 && status == resultList.size()) {
%>
<h3><%= result.replaceAll(",", " ") + " 상품삭제 성공" %>
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
