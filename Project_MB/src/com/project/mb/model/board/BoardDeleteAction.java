package com.project.mb.model.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dao.BoardDao;
import com.project.mb.dto.BoardDto;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int bIdx = Integer.parseInt(request.getParameter("bIdx"));
		
		BoardDto bDto = new BoardDto();
		bDto.setbIdx(bIdx);
		bDto.setbTitle("삭제된 게시글입니다.");
		bDto.setbDelete(-1);
		
		BoardDao bDao = BoardDao.getInstance();
		
		int result = bDao.getDeleteBoard(bDto);
		
		ActionForwad forward = new ActionForwad();
		
		if(result > 0 ) {
			forward.setPath("/Project_MB/boardList.bo");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글 삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return forward;
	}

}
