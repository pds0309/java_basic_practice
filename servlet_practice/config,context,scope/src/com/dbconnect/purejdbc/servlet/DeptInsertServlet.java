package com.dbconnect.purejdbc.servlet;

import com.dbconnect.purejdbc.dto.DeptDTO;
import com.dbconnect.purejdbc.service.DeptService;
import com.dbconnect.purejdbc.service.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/DeptInsertServlet")
public class DeptInsertServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 요청 처리하기
        String deptNo = request.getParameter("deptno");
        String dName = request.getParameter("dname");
        String loc = request.getParameter("loc");

        DeptDTO dto = new DeptDTO(Integer.parseInt(deptNo), dName, loc);
        int status = new DeptServiceImpl().insert(dto);
        //응답처리
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (status == 1) {
            out.println("저장성공");
            out.println("<a href='DeptListServlet'>목록화면</a>");
        }
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
