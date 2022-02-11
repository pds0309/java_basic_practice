<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-11
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Date d = new Date();
    List<Integer> list = new ArrayList<>();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Tag Syntax</title>
</head>
<body>
<h1>Response</h1>
<!-- java의 것들 선언하기 -->
<%
    List<String> stringList = new ArrayList<>();
    stringList.add("hello");
    stringList.add("world");
    stringList.add("Hommies");
%>
<!--브라우저에 출력하기 -->
<%=d.toString()%><br>
<%=stringList%><br>

<!-- ul Iteration 출력 -->
<ul>
    <%
        for (String s : stringList) {
    %>
    <!-- code what you want to do Iteration -->
    <li>
        <%= s %>
    </li>
    <%
        } // end loop
    %>
</ul>

<h3>Got Exception</h3>
<%
    List<String> exceptionList = null;
    try {
        System.out.println(exceptionList);
    } catch (Exception e) {
        System.out.println("Exception");
    }
%>

</body>
</html>