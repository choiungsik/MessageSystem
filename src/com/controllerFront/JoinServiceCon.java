package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.memberDAO;
import com.model.memberDTO;

public class JoinServiceCon implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String moveURL = null;
		memberDAO dao = new memberDAO();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");

		memberDTO dto = new memberDTO(email, pw, tel, addr);
		int cnt = dao.join(dto);
		
		if(cnt>0) {
			System.out.println("회원가입 성공");
			request.setAttribute("email", dto.getEmail());
			
			moveURL = "join_success.jsp";
		}else {
			System.out.println("회원가입 실패");
			moveURL = "main.jsp";
		}
		
		return moveURL;
	}

}
