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


@WebServlet("/ajaxJoin.me")
public class AjaxJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AjaxJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받은 파라미터 처리 (	data : $("#f").serialize(),  : 폼의 모든 데이터 )
				request.setCharacterEncoding("utf-8");
				String mId = request.getParameter("mId");
				String mPw = request.getParameter("mPw");
				String mName = request.getParameter("mName");
				String mNick = request.getParameter("mNick");
				
				MemberDto mDto = new MemberDto();
				mDto.setmId(mId);
				mDto.setmPw(mPw);
				mDto.setmName(mName);
				mDto.setmNick(mNick);
				
				// 3. MDao 생성
				MemberDao mDao = MemberDao.getInstance();
				
				int result = mDao.getInsertJoin(mDto);
				
				JSONObject obj = new JSONObject();
				// 5. 결과 result 생성
				
				if(result > 0) {
					obj.put("result", "SUCCESS");
				}else {
					obj.put("result", "FAIL");
				}
				
			
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				
				out.println(obj); // message 가 $.ajax ({,,, success(data)}) 의 data 로 전달 ~
			
			}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
