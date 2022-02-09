package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "TimeStampFilter")
public class TimeStampFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Init TimestampFilter");
    }

    public void destroy() {
        System.out.println("TimestampFilter Destroyed");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do TimeStampFilter");
        long reqTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long resTime = System.currentTimeMillis();
        System.out.println("End TimeStampFilter : " + (resTime - reqTime));
    }
}
