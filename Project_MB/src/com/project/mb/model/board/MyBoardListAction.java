package com.project.mb.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.common.Paging;
import com.project.mb.dao.BoardDao;
import com.project.mb.dto.BoardDto;
import com.project.mb.dto.MemberDto;

public class MyBoardListAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 현재 페이지 번호 구하기 (파라미터로 전달)
				request.setCharacterEncoding("utf-8");
				String currentPage = request.getParameter("currentPage");
				int nowPage = 1; // 기본 페이지 번호는 1로 정함
				if ( currentPage != null && !currentPage.isEmpty() ) {
					nowPage = Integer.parseInt(currentPage);
				}
				
				HttpSession session = request.getSession();
				MemberDto mDto = (MemberDto) session.getAttribute("loginDto");
				String mId = mDto.getmId();
				
				// 현재 페이지 번호를 request 에 저장
				request.setAttribute("currentPage", nowPage);
				
				// 현재 페이지 번호를 알면
				// 현재 페이지에 표시되는 게시글을 시작 번호와 끝 번호를 알 수 있다.
				// 추가로 페이지 당 게시글 수(recordPerPage)를 알아야 한다.
				int recordPerPage = 10;
				int begin = (nowPage - 1) * recordPerPage + 1;
				int end = begin + recordPerPage - 1;
				
				// BDao -> mapper 로 전달할 Map 생성
				Map<String, String> map = new HashMap<String, String>();
				map.put("begin", begin+"");
				map.put("end", end+"");
				map.put("mId", mId);
				
				// BDao 생성
				BoardDao bDao = BoardDao.getInstance();
				
				// BDao 의 getBoardList() 메소드 호출
				List<BoardDto> list = bDao.getMyBoardList(map);
				
				// request 에 list 저장
				request.setAttribute("list", list);
				
				// 게시물이 열리면 session 에 open 속성이 저장된다.
				// 목록으로 이동하는 경우에 그 값을 삭제한다.
				session.removeAttribute("open");
				
				// 내 게시글 개수 구하기
				int myRecord = bDao.getMyRecord(mId);
				
				// ◀ 1 2 3 ▶ 생성 (pagingView)
				String pagingView = Paging.getPaging("/Project_MB/myBoardList.bo", nowPage, recordPerPage, myRecord);
				
				// request 에 pagingView 저장
				request.setAttribute("pagingView", pagingView);
				
				// 결과 경로 + 이동 방법을 저장할 ActionForward 생성
				ActionForwad forward = new ActionForwad();
				forward.setPath("/board/boardList.jsp");
				forward.setRedirect(false);
				
				return forward;
				
			}

		}