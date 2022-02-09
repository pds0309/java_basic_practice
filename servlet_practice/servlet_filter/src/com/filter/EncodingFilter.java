package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("EncodingFilter init");
    }

    public void destroy() {
        System.out.println("EncodingFilter Destroyed");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // ---요청필터---
        System.out.println("Do EncodingFilter");
        //한글 '요청' 처리
        request.setCharacterEncoding("utf-8");
        // 필터를 chain에 걸기
        // ?? 안걸면 어떻게 될까?
        //   체인을 연결해주지 않으면 서블릿 단으로 요청이 넘어가지 못하고 머무르게 된다.
        chain.doFilter(request, response);
        // chain.doFilter() 를 기준으로 뒤에는 응답필터를 작성한다.

        /// ---응답필터---
        System.out.println("End EncodingFilter");
    }
}
