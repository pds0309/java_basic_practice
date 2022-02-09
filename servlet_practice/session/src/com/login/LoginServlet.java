package com.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청을 받아옴
        String userid = request.getParameter("userid");
        String password = request.getParameter("passwd");

        //DB 연동 유효성 체크하기
        boolean result = true;
        String mesg = "";
        if (result) {

            //세션얻기
            // request.getSession(): 세션이 있으면 반환하고 세션이 없으면 생성후 반환한다.
            HttpSession session = request.getSession();
            //데이터 저장
            session.setAttribute("m1", userid);

            mesg += "안녕하세요" + userid + "님";
            mesg += "<h2>로그인성공</h2>";
            mesg += " <a href='MemberInfoServlet'>회원정보보기</a>";
        } else {
            //userid 또는 passwd 틀림
            //다시 로그인 또는 회원가입하도록 유도
            mesg += "<h2>로그인실패</h2>";
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
