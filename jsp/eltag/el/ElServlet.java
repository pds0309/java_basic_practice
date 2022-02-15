package com.el;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ElServlet")
public class ElServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //scope 에 속성 저장
        // 1. request scope
        req.setAttribute("request", "김갑환");

        // 1-1. request scope DTO
        req.setAttribute("requestdto", new ElExamDTO("최번게", 25));


        // 1-2 . request scope Collection
        List<ElExamDTO> elExamDTOList = new ArrayList<>();
        elExamDTOList.add(new ElExamDTO("장거한", 45));
        elExamDTOList.add(new ElExamDTO("이오리", 25));
        req.setAttribute("requestlist", elExamDTOList);


        // 2. session scope
        HttpSession session = req.getSession();
        session.setAttribute("session","세션이얌");

        // 3. Application scope

        ServletContext application = getServletContext();
        application.setAttribute("app","앱이욤");

        req.getRequestDispatcher("el.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
