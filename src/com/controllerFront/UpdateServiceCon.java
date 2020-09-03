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
		
		info = new memberDTO(email, pw, tel, addr);   // �ٲ� ������ info �� ����
		
		if (cnt > 0) {
			session.setAttribute("info", info);  // �ٲ� ������ ���� ���Ǽ���
			System.out.println("���������Ϸ�");	
		}else {
			System.out.println("������������");
		}
		moveURL ="main.jsp";
		
		return moveURL;
	}

}
