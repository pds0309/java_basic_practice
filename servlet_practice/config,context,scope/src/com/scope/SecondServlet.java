package com.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// SecondServlet : 데이터 조회 역할
@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Application scope 데이터 조회
        ServletContext application = getServletContext();
        String applicationResult = (String) application.getAttribute("application");

        // 2. Session scope 데이터 조회
        HttpSession session = request.getSession();
        String sessionResult = (String) session.getAttribute("session");

        // 3. Request scope 데이터 조회
        String requestResult = (String) request.getAttribute("request");

        // 애플리케이션 단에서 생명주기를 가진다.
        System.out.println("Application Scope : " + applicationResult);
        // 같은 브라우저 내에서 생명주기가 동일하다.
        System.out.println("Session Scope : " + sessionResult);
        // 하나의 요청에 대해서만 생명주기를 가지기 때문에 값을 가져올 수 없다.
        System.out.println("Request Scope : " + requestResult);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
