package com.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberListServlet", value = "/MemberListServlet")
public class MemberListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberDTO memberDTO = (MemberDTO) session.getAttribute("key1");

        String result = "";


        if (memberDTO == null) {
            result += "불러올 수 없음";
        } else {
            result += "세션에 등록된 정보 :" + memberDTO.toString();
        }
        response.setContentType("text/html;charset=utf-8");
        String html = "<html><body>";
        html += result;
        html += "<a href='member.html'>회원등록화면</a>";
        html += "</body></html>";
        PrintWriter out = response.getWriter();
        out.println(html);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
