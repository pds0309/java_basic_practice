package com;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "김갑환");
        request.setAttribute("age", 25);
        request.setAttribute("str", "HelLo");
        request.setAttribute("str2", "999999-1111111");
        request.setAttribute("str3", "  김갑환  ");
        request.setAttribute("str4", "aaa/bbb/ccc");
        request.setAttribute("tokens", "AAA/BBB/CCC");
        List<PersonDTO> personDTOList = new ArrayList<>();
        personDTOList.add(new PersonDTO(35, "장거한"));
        personDTOList.add(new PersonDTO(42, "최번개"));
        request.setAttribute("list", personDTOList);
        request.getRequestDispatcher("jstl.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
