package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.memberDTO;
import com.model.messageDAO;
import com.model.messageDTO;

@WebServlet("/MessageServiceCon")
public class MessageServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		String send = request.getParameter("send");
		String re = request.getParameter("receive");
		String me = request.getParameter("message");
		
		messageDTO dto = new messageDTO(send, re, me);
		messageDAO dao = new messageDAO();
		int cnt = dao.send(dto);
		
		if (cnt >0) {
			System.out.println("메세지 전송성공");
		} else {
			System.out.println("메세지 전송실패");
		}
		response.sendRedirect("main.jsp");
	}

}
