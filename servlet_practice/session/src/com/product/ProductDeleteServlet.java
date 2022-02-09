package com.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductDeleteServlet", value = "/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String inputIdForDelete = request.getParameter("deleteid");

        HttpSession session = request.getSession();

        int status = 201;

        if (session.getAttribute("key1") != null) {
            List<ProductDTO> productDTOList = (List<ProductDTO>) session.getAttribute("key1");
            for (int i = 0; i < productDTOList.size(); i++) {
                if (productDTOList.get(i).getProductId().equals(inputIdForDelete)) {
                    productDTOList.remove(i);
                    status = 200;
                    break;
                }
            }
            session.setAttribute("key1", productDTOList);
        }
        String result = "정상적으로 삭제하지 못함(잘못된 입력 또는 없는 상품입니다.)";
        if (status == 200) {
            result = "정상적으로 삭제함";
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print(result);
        out.println("<a href='product.html'>등록화면보기</a>");
        out.println("<a href='ProductListServlet'>상품목록보기</a>");
        out.print("</body></html>");
    }
}
