package com.servlet;

import com.dto.PageDTO;
import com.dto.StudentDTO;
import com.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentAllServlet2", value = "/StudentAllServlet2")
public class StudentAllServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPage = request.getParameter("currentpage");
        if (currentPage == null) {
            currentPage = "1";
        }
        int updatedcurrentPage = Integer.parseInt(currentPage);
        PageDTO<StudentDTO> studentDTOPageDTO = new StudentServiceImpl().selectAllPageable2(3, updatedcurrentPage);

        int totalPageNum = (int) Math.ceil((double) studentDTOPageDTO.getTotalCount() / studentDTOPageDTO.getPerPage());
        String result = "";
        String pageList = "";

        for (StudentDTO student : studentDTOPageDTO.gettList()) {
            result += "<tr>";
            result += "<td>" + student.getStudentNo() + "</td>";
            result += "<td>" + student.getStudentName() + "</td>";
            result += "<td>" + student.getStudentSsn() + "</td>";
            result += "<td>" + student.getStudentAddress() + "</td>";
            result += "<td>" + student.getEntranceDate() + "</td>";
            result += "<td>" + student.getAbsenceYn() + "</td></tr>";
        }

        for (int i = 1; i <= totalPageNum; i++) {
            if (updatedcurrentPage == i) {
                pageList += "" + i + "&nbsp;&nbsp";
                continue;
            }
            pageList += "<a href='StudentAllServlet?currentpage=" + i + "'>" + i + "</a>&nbsp;&nbsp;";
        }

        String html = "<html><body>";
        html += "    <table border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>학번</th>\n" +
                "            <th>이름</th>\n" +
                "            <th>주민번호</th>\n" +
                "            <th>주소</th>\n" +
                "            <th>입학일</th>\n" +
                "            <th>휴학여부</th>\n" +
                "        </tr>\n" + result +
                "    </table><br />";
        html += pageList;
        html += "</body></html>";

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
