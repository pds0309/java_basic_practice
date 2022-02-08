package com.contextparam;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로직 처리
		//1. 초기화 파라미터 접근 방법- ServletConfig의 getInitParameter(name) 사용
		String driver = getInitParameter("driver");
		String username = getInitParameter("username");
		System.out.println(driver+"\t"+username);  // null null ==> 이유는 FirstServlet만 접근가능
		
		//2. 컨텍스트 파라미터 접근
		ServletContext ctx = getServletContext();
		String userid = ctx.getInitParameter("userid");
		String passwd = ctx.getInitParameter("passwd");
		System.out.println(userid+"\t"+passwd);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
