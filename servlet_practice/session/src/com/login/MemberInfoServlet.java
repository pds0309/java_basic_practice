package com.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MemberInfoServlet")
public class MemberInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//세션얻기
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("m1");
        String mesg = "";
        //null 체크
        /*
         *  이유?
         *   1) 정상적인 로그인 절차 거치지 않은 경우
         *   2) 로그인 했지만 time-out 된 경우
         *
         */
        if (userid != null) {
            mesg += "<h2>회원정보</h2>";
            mesg += "아이디:" + userid;
            mesg += " <a href=''>로그아웃</a>";

        } else {
            //세션정보그 없기 때문에 다시 로그인하도록 유도
            mesg += "<h2>세션정보제거됨</h2>";
            mesg += " <a href='loginForm.html'>로그인화면</a>";
        }

        //응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print(mesg);
        out.print("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
