package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.memberDAO;
import com.model.memberDTO;

@WebServlet("/UpdateServiceCon")
public class UpdateServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		memberDTO info = (memberDTO) session.getAttribute("info");
		
		request.setCharacterEncoding("EUC-KR");
		String email = info.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		System.out.println(pw);
		System.out.println(tel);
		System.out.println(addr);
		
		info = new memberDTO(email, pw, tel, addr);
		memberDAO dao = new memberDAO();
		int cnt = dao.update(info);
		
		info = new memberDTO(email, pw, tel, addr);   // �ٲ� ������ info �� ����
		
		if (cnt > 0) {
			session.setAttribute("info", info);  // �ٲ� ������ ���� ���Ǽ���
			System.out.println("���������Ϸ�");	
		}else {
			System.out.println("������������");
		}
		response.sendRedirect("main.jsp");
	}

} 











