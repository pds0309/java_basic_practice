package com.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDeleteAllServlet", value = "/ProductDeleteAllServlet")
public class ProductDeleteAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("정상적으로 모두 삭제함");
        out.println("<a href='product.html'>등록화면보기</a>");
        out.println("<a href='ProductListServlet'>상품목록보기</a>");
        out.print("</body></html>");
    }
}
