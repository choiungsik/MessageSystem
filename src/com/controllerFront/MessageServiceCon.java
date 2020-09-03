package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.messageDAO;
import com.model.messageDTO;

public class MessageServiceCon implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		messageDAO dao = new messageDAO();
		String send = request.getParameter("send");
		String re = request.getParameter("receive");
		String me = request.getParameter("message");
		String moveURL = null;
		
		messageDTO dto = new messageDTO(send, re, me);
		int cnt = dao.send(dto);
		
		if (cnt >0) {
			System.out.println("메세지 전송성공");
		} else {
			System.out.println("메세지 전송실패");
		}
		moveURL = "main.jsp";
		
		return moveURL;
	}

}
