package com;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/examform")
public class RequestProcessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //요청처리
        System.out.println("doGET");
        String userId = request.getParameter("userid");
        String[] hobbies = request.getParameterValues("hobby");
        String comment = request.getParameter("comments");

        System.out.println(userId);
        System.out.println(Arrays.toString(hobbies));
        System.out.println(comment);
        
        //응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>HI</h1>");
        out.println("ID: " + userId );
        out.println("<br />[Hobby]: " + Arrays.toString(hobbies));
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPOST");
        request.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userid");
        String[] hobbies = request.getParameterValues("hobby");
        String comment = request.getParameter("comments");
        System.out.println(userId);
        System.out.println(Arrays.toString(hobbies));
        System.out.println(comment);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>HI</h1>");
        out.println("ID: " + userId );
        out.println("<br />[Hobby]: " + Arrays.toString(hobbies));
        out.println("</body></html>");
    }
}
