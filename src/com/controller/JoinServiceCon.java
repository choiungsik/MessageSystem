package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.memberDAO;
import com.model.memberDTO;

@WebServlet("/JoinServiceCon")
public class JoinServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		Connection conn = null;
		PreparedStatement psmt =null;

		memberDAO dao = new memberDAO();
		memberDTO dto = new memberDTO(email, pw, tel, addr);
		int cnt = dao.join(dto);
		
		if(cnt>0) {
			System.out.println("회원가입 성공");
			request.setAttribute("email", dto.getEmail());
			
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp"); //request 값 보낼 주소설정
			rd.forward(request, response);  // 값 발송(이건 서버에 보내서 서버에서 이동하기에 진행단계가 적어 효율적이고 보완적인 측면에서도 좋음, url은 요청한 값을 사용)
			
			response.sendRedirect("join_success.jsp");
		}else {
			System.out.println("회원가입 실패");
			response.sendRedirect("main.jsp");
		}
	}
	 

}
