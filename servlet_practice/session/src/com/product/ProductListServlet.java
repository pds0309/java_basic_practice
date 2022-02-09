package com.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> productDTOList = (List<ProductDTO>) request.getSession().getAttribute("key1");

        String result = "";

        if (productDTOList == null || productDTOList.size() == 0) {
            result += "<td>저장된 상품 없음</td>";
        } else {
            for (ProductDTO productDTO : productDTOList) {
                result += "<tr><td>" + productDTO.getProductId() + "</td>";
                result += "<td>" + productDTO.getProductName() + "</td>";
                result += "<td>" + productDTO.getProductAmount() + "</td></tr>";
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>";
        html += "<a href='product.html'>등록화면보기</a>";
        html += "<form action='ProductDeleteAllServlet' method='post'><input type='submit' value='모두삭제'></form>";
        html += "<a href='productdeleteform.html' target='_blank'>특정상품삭제</a>";
        html += "<table border='1'>";
        html += "<tr><td>상품 아이디</td><td>상품명 </td><td>갯수</td></tr>";
        html += result;
        html += "</table>";
        html += "</body></html>";
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
