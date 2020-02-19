package com.project.mb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.model.board.BoardDeleteAction;
import com.project.mb.model.board.BoardInsertAction;
import com.project.mb.model.board.BoardListAction;
import com.project.mb.model.board.BoardViewAction;
import com.project.mb.model.board.MyBoardListAction;
import com.project.mb.model.board.ReplyInsertAction;


@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
       
    }

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request, response 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인 (xxxx.bo)
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		// Action action 선언 (DB 사용할 때 생성)
		Action action = null;
		
		// ActionForward forward 선언 (이동경로 + 이동방법을 저장할 객체(forward) 생성)
		ActionForwad forward = null;
		
		// cmd 에 다른 model 호출
		try {
			switch (cmd) {

			// 단순 이동 (model 없이 진행, 포워드)
			case "/boardWritePage.bo" :
				forward = new ActionForwad();
				forward.setPath("/board/boardWritePage.jsp");
				break;
				
			case "/replyPage.bo" :
				forward = new ActionForwad();
				forward.setPath("/board/replyPage.jsp");
				break;
			
			// DB이동
			case "/boardList.bo":
				action = new BoardListAction();
				forward = action.execute(request, response);
				break;
				
			case "/boardWrite.bo" :
				action = new BoardInsertAction();
				forward = action.execute(request, response);
				break;
		
			case "/boardViewPage.bo" :
				action = new BoardViewAction();
				forward = action.execute(request, response);
				break;
			case "/boardDelete.bo" :
				action = new BoardDeleteAction();
				forward = action.execute(request, response);
				break;
			case "/replyWrite.bo" :
				action = new ReplyInsertAction();
				forward = action.execute(request, response);
				break;
				
			case "/myBoardList.bo":
				action = new MyBoardListAction();
				forward = action.execute(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 요청 실행
		if ( forward != null ) {
			if ( forward.isRedirect() ) { // 리다이렉트인가?
				response.sendRedirect( forward.getPath() );
			} else {
				request.getRequestDispatcher( forward.getPath() ).forward(request, response);
			}
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
