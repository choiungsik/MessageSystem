package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDTO;
import com.model.messageDAO;

@WebServlet("/DeleteServiceCon")
public class DeleteServiceCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		memberDTO info = (memberDTO)session.getAttribute("info");
		
		String email = info.getEmail();
		
		messageDAO dao = new messageDAO();
		int cnt = dao.delete(email);
		
		if (cnt > 0) {
			System.out.println("메세지 삭제 성공");
		} else {
			System.out.println("메세지 삭제 실패");
		}
		response.sendRedirect("main.jsp");
	}

}
