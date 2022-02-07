package com.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>");
        out.println("이름");
        out.println("나이");
        out.println("주소");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("김갑환");
        out.println("25");
        out.println("캘리포니아");
        out.println("</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
