package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDAO;
import com.model.memberDTO;

public class LoginServiceCon implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		memberDAO dao = new memberDAO();
		String moveURL = null;
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		memberDTO dto = new memberDTO(email, pw);
		
		memberDTO info = dao.login(dto);
		
		if (info != null) {
			System.out.println("로그인세션성공");
			session.setAttribute("info", info);
		}else {
			System.out.println("로그인세션실패");
		}
		moveURL = "main.jsp";
		
		return moveURL;
	}

}
