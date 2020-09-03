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
			System.out.println("ȸ������ ����");
			request.setAttribute("email", dto.getEmail());
			
			RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp"); //request �� ���� �ּҼ���
			rd.forward(request, response);  // �� �߼�(�̰� ������ ������ �������� �̵��ϱ⿡ ����ܰ谡 ���� ȿ�����̰� �������� ���鿡���� ����, url�� ��û�� ���� ���)
			
			response.sendRedirect("join_success.jsp");
		}else {
			System.out.println("ȸ������ ����");
			response.sendRedirect("main.jsp");
		}
	}
	 

}
