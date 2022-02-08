package com.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// FirstServlet : scope 에 데이터 저장
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Application Scope 에 저장
        // servletContext 가져오기
        ServletContext application = getServletContext();
        // 저장
        application.setAttribute("application", "App");

        //2. Session Scope
        // session 가져오기
        HttpSession session = request.getSession();
        // 저장
        session.setAttribute("session", "Session");

        //3. Request Scope
        // 저장
        request.setAttribute("request", "Req");

        System.out.println("Scope Save Success!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
