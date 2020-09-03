package com.controllerFront;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDAO;
import com.model.memberDTO;

public class UpdateServiceCon implements command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		memberDAO dao = new memberDAO();
		memberDTO info = (memberDTO) session.getAttribute("info");
		
		String moveURL = null;
		String email = info.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		info = new memberDTO(email, pw, tel, addr);
		int cnt = dao.update(info);
		
		info = new memberDTO(email, pw, tel, addr);   // 바꾼 정보로 info 값 변경
		
		if (cnt > 0) {
			session.setAttribute("info", info);  // 바뀐 정보로 새로 세션설정
			System.out.println("정보수정완료");	
		}else {
			System.out.println("정보수정실패");
		}
		moveURL ="main.jsp";
		
		return moveURL;
	}

}
