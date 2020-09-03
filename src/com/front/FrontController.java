package com.front;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.controllerFront.DeleteOneCon;
import com.controllerFront.DeleteServiceCon;
import com.controllerFront.JoinServiceCon;
import com.controllerFront.LoginServiceCon;
import com.controllerFront.Logout;
import com.controllerFront.MessageServiceCon;
import com.controllerFront.UpdateServiceCon;
import com.controllerFront.command;

@WebServlet("*.do") //� servlet�̵� .do�� ������ �� �������� �Ѿ������ �ۼ�
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");
		RequestDispatcher rd = null;
		String moveURL = null;
		
		command command = null;
		
		String reqURI = request.getRequestURI();
		System.out.println(reqURI);  //������Ʈ ����� �ִ� uri�ּ� Ȯ��
		String path = request.getContextPath();
		System.out.println(path);  //������Ʈ�� ��������
		System.out.println(reqURI.substring(path.length())); //������Ʈ���� ũ�⸸ŭ �ش��ϴ� �ּ� �߶� ���
		String resultURI = reqURI.substring(path.length()+1);
		System.out.println(resultURI);
		
		if (resultURI.equals("DeleteOneCon.do")) {
			command = new DeleteOneCon();
		}else if (resultURI.equals("DeleteServiceCon.do")) {
			command = new DeleteServiceCon();
		}else if (resultURI.equals("JoinServiceCon.do")) {
			command = new JoinServiceCon();	
		}else if (resultURI.equals("LoginServiceCon.do")) {
			command = new LoginServiceCon();		
		}else if (resultURI.equals("Logout.do")) {
			command = new Logout();		
		}else if (resultURI.equals("MessageServiceCon.do")) {
			command = new MessageServiceCon();			
		}else if (resultURI.equals("UpdateServiceCon.do")) {
			command = new UpdateServiceCon();
		}
		//���� �ٸ� Ŭ�������� ���� command �������̽��� �޾� ��ĳ�������� �ϳ��� ��ɾ�� ����
		//request �� response�� �޾� execute���� �ش� ����� �����ϵ��� class�� ¥����
		//�ش簪�� ������ ������ �۾��� �����ϰ� ���ư� ������ �̵��� URI���� ��Ʈ������ ����
		moveURL = command.execute(request, response);

		if (moveURL.equals("join_success.jsp")) {
			rd = request.getRequestDispatcher("join_success.jsp"); //request �� ���� �ּҼ���
			rd.forward(request, response); // �� �߼�(�̰� ������ ������ �������� �̵��ϱ⿡ ����ܰ谡 ���� ȿ�����̰� �������� ���鿡���� ����, url�� ��û�� ���� ���)				
		}
		
		response.sendRedirect(moveURL);
	}

}
