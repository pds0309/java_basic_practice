package com.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/SetCookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//현재 시간 구하기
        Calendar cal = Calendar.getInstance();
        String time = cal.get(Calendar.YEAR)+"년"
                + cal.get(Calendar.HOUR_OF_DAY)+"시"+cal.get(Calendar.MINUTE)+"분"+cal.get(Calendar.SECOND);
        //1. 쿠키 생성
        Cookie c = new Cookie("current_time", time );
        c.setMaxAge(3600);
//        Cookie c = new Cookie("currentTime", URLEncoder.encode(d.toString(), "utf-8"));
        //2. 응답에 쿠키 저장
        response.addCookie(c);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
