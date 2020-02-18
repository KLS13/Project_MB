package com.project.mb.model.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.project.mb.dao.MemberDao;
import com.project.mb.dto.MemberDto;

@WebServlet("/ajaxIdCheck.me")
public class AjaxIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxIdCheck() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// 전발받은 파라미터 처리
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		
		MemberDao mDao = MemberDao.getInstance();
		
		MemberDto mDto = mDao.getMemberId(mId);
		
		// 결과를 저장할 JSONObject 객체 생성
		JSONObject obj = new JSONObject();
		
		// 아이디가 있으면 "result" 키 값에 "YES" 저장 {"result":"YES"}
		// 아이디가 없으면 "result" 키 값에 "NO" 저장	{"result":"NO"}
		if( mDto != null ) {
			obj.put("result", "YES");
		}else {
			obj.put("result", "NO");
		}
		
		// obj를 응답(response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(obj);  //JSONObject obj를 응답
						// success : function(jsonObj) {  의 jsonObj 로 전달
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
