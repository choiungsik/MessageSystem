package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.messageDAO;

@WebServlet("/DeleteOneCon")
public class DeleteOneCon extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		
		System.out.println(num);
		
		messageDAO dao = new messageDAO();
		int cnt = dao.deleteOne(num);
		
		if (cnt > 0) {
			System.out.println("해당 메세지 삭제");
		} else{
			System.out.println("해당 메세지 삭제실패");
		}
		response.sendRedirect("main.jsp");
	}

}
