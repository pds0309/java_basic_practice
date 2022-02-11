<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ehd03
  Date: 2022-02-11
  Time: 오후 2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Logic JSP</title>
</head>
<body>

<%
    String userId = request.getParameter("userid");
    String password = request.getParameter("password");
    System.out.println("웹컨테이너콘솔 출력 " + userId + " " + password);
    PrintWriter OUT = response.getWriter();
    OUT.println("브라우저출력 : " + userId);

    // JSPWriter
    // need Library Dependency
    // - javax.servlet.jsp
    out.print("브라우저 출력 " + userId);

    // 세션
    session.setAttribute("id", userId);
    // 컨텍스트
    application.setAttribute("id",userId);
    // 초기화 파라미터
    String initParam = config.getInitParameter("driver");
    System.out.println(initParam);
%>

</body>
</html>
