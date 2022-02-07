package com;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    // 서블릿은 한번만 생성됨
    // => 인스턴스변수가 한번만 생성된다.
    // => 인스턴스 변수를 여러 사용자가 공유할 수 있다.
    List<String> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list.add("hello");
        System.out.println(list);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
