package com.project.mb.model.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.project.mb.dao.MemberDao;


@WebServlet("/ajaxChangePw.me")
public class AjaxChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AjaxChangePw() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받은 파라미터 처리 (	data : $("#f").serialize(),  : 폼의 모든 데이터 )
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		// 2. MDao  --> mapper 에게 전달할 Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("mPw", mPw);
		
		// 3. MDao 생성
		MemberDao mDao = MemberDao.getInstance();
		
		// 4. MDao 의 getUpdatemPw() 메소드 호출
		int result = mDao.getUpdatemPw(map);
		// 5. 결과 result 생성
		String message = null;
		if(result > 0) {
			message = "SUCCESS";
		}else {
			message = "FAIL";
		}
		
		// 6. message 를 응답
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(message); // message 가 $.ajax ({,,, success(data)}) 의 data 로 전달 ~
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
