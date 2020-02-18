package com.project.mb.model.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dao.MemberDao;
import com.project.mb.dto.MemberDto;

public class LoginAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// loginPage.jsp 에서 전달되는 파라미터 처리
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		// Mdao -> mapper 에게 전달할 MemberDto 생성
		MemberDto mDto = new MemberDto();
		mDto.setmId(mId);
		mDto.setmPw(mPw);
		
		// MDao 생성
		MemberDao mDao = MemberDao.getInstance();
		
		// MDao 의 getMemberBymIdmPw() 메소드 호출
		MemberDto loginDto = mDao.getMemberLogin(mDto);
		
		// 결과 경로 + 이동 방법을 저장할 ActionForward 생성
		ActionForwad forward = new ActionForwad();
		
		// 로그인 된 회원 loginDto 를 session 에 저장하기 위해 session 선언
		HttpSession session = null;
		
		// 로그인 성공 -> loginDto 를 session 에 저장, index.jsp 로 이동, 리다이렉트 이동
		// 로그인 실패 -> 이전 페이지로 이동
		if ( loginDto != null ) {
			session = request.getSession();
			session.setAttribute("loginDto", loginDto);
			forward.setPath("index.jsp");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); // Exception 처리가 필요 ---> MemberController 로 예외를 throw
			out.println("<script type='text/javascript'>");
			out.println("alert('일치하는 회원 정보가 없습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
	
		return forward;
		
	}

}