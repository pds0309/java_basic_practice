package com.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductAddServlet", value = "/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String productName = request.getParameter("productname");
        String productId = request.getParameter("productid");
        String amount = request.getParameter("productamount");

        ProductDTO productDTO = new ProductDTO(productName, productId, Integer.parseInt(amount));
        HttpSession session = request.getSession();


        String result = "";

        if (session.getAttribute("key1") == null && productDTO == null) {
            result += "<h3>알수 없는 오류</h3>";
        } else if (session.getAttribute("key1") == null) {
            List<ProductDTO> list = new ArrayList<>();
            list.add(productDTO);
            session.setAttribute("key1", list);
        } else {
            List<ProductDTO> productDTOList = (List<ProductDTO>) session.getAttribute("key1");

            boolean exist = false;
            for (ProductDTO productDTO1 : productDTOList) {
                if (productDTO.getProductId().equals(productDTO1.getProductId())) {
                    exist = true;
                    productDTO1.setProductAmount(productDTO.getProductAmount());
                    break;
                }
            }
            if (!exist) {
                productDTOList.add(productDTO);
            }
            session.setAttribute("key1", productDTOList);
        }
        result += "<h3>상품 등록 성공!</h3>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String html = "<html><body>";
        html += result;
        html += "<a href='product.html'>등록화면보기</a>";
        html += "<a href='ProductListServlet'>상품목록보기</a>";
        html += "</body></html>";
        out.println(html);
    }
}
