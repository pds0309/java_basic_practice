package com.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberAddServlet", value = "/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        MemberDTO memberDTO = new MemberDTO(name, Integer.parseInt(age), address);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("key1") != null) {
            MemberDTO member = (MemberDTO) session.getAttribute("key1");
            if (name.equals(member.getName())) {
                String html = "<html><body>";
                html += "<h2>중복된 데이터로 저장 실패</h2>";
                html += "<a href='member.html'>입력 화면으로</a>";
                html += "</body></html>";
                out.println(html);
                return;
            }
        }
        session.setAttribute("key1", memberDTO);
        if (memberDTO == null) {
            out.println("알 수 없는 접근 오류");
            return;
        }
        String html = "<html><body>";
        html += "<h2>세션에 이름/나이/주소 저장 성공</h2>";
        html += "<a href='MemberListServlet'>세션 정보 보기</a>";
        html += "</body></html>";
        out.println(html);
    }
}
