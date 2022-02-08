package com.dbconnect.purejdbc.servlet;

import com.dbconnect.purejdbc.dto.DeptDTO;
import com.dbconnect.purejdbc.service.DeptService;
import com.dbconnect.purejdbc.service.DeptServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/DeptListServlet")
public class DeptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptService service = new DeptServiceImpl();
        List<DeptDTO> list = service.selectAll();
        ServletContext context = getServletContext();
        //응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>");
        for (DeptDTO deptDTO : list) {
            int deptno = deptDTO.getDeptNo();
            String dname = deptDTO.getdName();
            String loc = deptDTO.getLoc();
            out.println("<tr><th>" + deptno + "</th><th>" + dname + "</th><th>" + loc + "</th></tr>");
        }
        out.println("</table>");
        out.println("<a href='DeptInsertServlet'>등록화면</a>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
