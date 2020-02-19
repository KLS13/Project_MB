package com.project.mb.model.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dao.BoardDao;
import com.project.mb.dto.BoardDto;

public class BoardViewAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int bIdx = Integer.parseInt(request.getParameter("bIdx"));
		String currentPage = request.getParameter("currentPage");
		request.setAttribute("currentPage", currentPage);
		
		BoardDao bDao = BoardDao.getInstance();
		
		BoardDto bDto = bDao.getBoardBybIdx(bIdx);
		request.setAttribute("bDto", bDto);
		
		// hit 증가
		HttpSession session = request.getSession();
		String open = (String) session.getAttribute("open");
		if(open==null) {
			session.setAttribute("open", "YES");
			bDao.getUpdateHit(bIdx);
		}
		
		
		ActionForwad forward = new ActionForwad();
		
		if(bDto != null) {
			forward.setPath("/board/boardViewPage.jsp");
			forward.setRedirect(false);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글 불러오기 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return forward;
	}

}
