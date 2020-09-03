package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDTO;
import com.model.messageDAO;

public class DeleteServiceCon implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;
		HttpSession session = request.getSession();
		messageDAO dao = new messageDAO();
		memberDTO info = (memberDTO)session.getAttribute("info");
		
		String email = info.getEmail();
		
		int cnt = dao.delete(email);
		
		if (cnt > 0) {
			System.out.println("�޼��� ���� ����");
		} else {
			System.out.println("�޼��� ���� ����");
		}
		moveURL = "main.jsp";
		return moveURL;
	}

}
