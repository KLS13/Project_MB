package com.project.mb.model.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dto.MemberDto;

public class LogoutAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 된 회원의 정보를 session 에서 제거
				HttpSession session = request.getSession();
				MemberDto mDto = (MemberDto) session.getAttribute("loginDto");
				
				// 결과 경로 + 이동 방법을 저장할 ActionForward 생성
				ActionForwad forward = new ActionForwad();
				
				// 로그인 중이면 -> session 초기화, index.jsp 이동
				// 로그인이 아니면 -> 이전 페이지로 이동
				if ( mDto != null ) {
					session.invalidate(); // 세션 초기화
					forward.setPath("index.jsp");
					forward.setRedirect(true); // 리다이렉트
				} else {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter(); // Exception 처리가 필요 (MemberController 로 예외를 throw)
					out.println("<script type='text/javascript'>");
					out.println("alert('로그인 된 회원의 정보가 없습니다.')");
					out.println("history.back()");
					out.println("</script>");
					out.close();
				}
				
				return forward;
			}

		}