package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.messageDAO;

public class DeleteOneCon implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;

		String num = request.getParameter("num");
		messageDAO dao = new messageDAO();
		
		int cnt = dao.deleteOne(num);
		
		if (cnt > 0) {
			System.out.println("해당 메세지 삭제");
		} else{
			System.out.println("해당 메세지 삭제실패");
		}
		moveURL = "main.jsp";
		return moveURL;
	}
}
