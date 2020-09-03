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

@WebServlet("*.do") //어떤 servlet이든 .do만 있으면 이 페이지로 넘어오도록 작성
public class FrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("EUC-KR");
		RequestDispatcher rd = null;
		String moveURL = null;
		
		command command = null;
		
		String reqURI = request.getRequestURI();
		System.out.println(reqURI);  //프로젝트 명까지 있는 uri주소 확인
		String path = request.getContextPath();
		System.out.println(path);  //프로젝트만 가져오기
		System.out.println(reqURI.substring(path.length())); //프로젝트명의 크기만큼 해당하는 주소 잘라서 사용
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
		//각각 다른 클래스지만 같은 command 인터페이스를 받아 업캐스팅으로 하나의 명령어로 묶음
		//request 와 response를 받아 execute에서 해당 기능을 수행하도록 class를 짜놓음
		//해당값은 가져간 값으로 작업을 실행하고 돌아갈 값으로 이동할 URI값을 스트링으로 보냄
		moveURL = command.execute(request, response);

		if (moveURL.equals("join_success.jsp")) {
			rd = request.getRequestDispatcher("join_success.jsp"); //request 값 보낼 주소설정
			rd.forward(request, response); // 값 발송(이건 서버에 보내서 서버에서 이동하기에 진행단계가 적어 효율적이고 보완적인 측면에서도 좋음, url은 요청한 값을 사용)				
		}
		
		response.sendRedirect(moveURL);
	}

}
