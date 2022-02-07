package com;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// annotation 방식 servlet mapping
//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    // 생성할 때 호출되는 콜백 메소드 (일반적으로는 사용 X)
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("INIT - INIT");
    }

    // 삭제할 때 호출되는 콜백 메소드
    @Override
    public void destroy() {
        System.out.println("DESTROY - DESTROY");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 비즈니스 로직 처리
        System.out.println("GET - Hi");
        Date date = new Date();

        // 2. html 작성해서 응답
        //       가. MIME 타입 지정( 브라우저에게 처리할 데이터 타입 지정)
        // contentType 잘못 주면 다운로드 창이 나온다.
        //   왜?
        //      - 브라우저에게 처리할 데이터 타입을 지정해주는 건데
        //      - 브라우저가 이 타입이 뭔지 몰라서 그럼
        //      - 그렇다고 없앨수는 없고 다운로드 시켜버리는 거임
        response.setContentType("text/html;charset=utf-8");
        //       나. 출력 API 로 응답
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>HELL</h1>");
        out.println("현재시간" + date.toString());
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
