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

import com.project.mb.dao.MemberDao;
import com.project.mb.dto.MemberDto;

@WebServlet("/ajaxSearchPw.me")
public class AjaxSearchPw extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxSearchPw() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 전달 받은 파라미터 처리(data: "mId=" + $("#mId").val() + "&mPhone=" + $("#mPhone").val(),)
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		String mNick = request.getParameter("mNick");
		
		// 2. MDao -> mapper 까지 전달할 Map 생성
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("mNick", mNick);
		
		// 3. MDao 생성
		MemberDao mDao = MemberDao.getInstance();
		
		// 4. MDao 의 getMemberBymIdmPhone() 메소드 호출
		MemberDto mDto = mDao.getMemberBymIdmNick(map);
		
		// 5. 결과 result 만들기
		String result = null;
		if ( mDto == null ) {
			result = "NO";
		} else {
			result = "YES";
		}
		
		// 6. result 를 응답(response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result); // result 가 $.ajax({,,,success(data)}) 의 data 로 전달
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
