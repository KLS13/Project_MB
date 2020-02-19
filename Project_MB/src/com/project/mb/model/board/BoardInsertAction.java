package com.project.mb.model.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dao.BoardDao;
import com.project.mb.dto.BoardDto;

public class BoardInsertAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String bTitle = request.getParameter("bTitle");
		String mId = request.getParameter("mId");
		String bContent = request.getParameter("bContent");
		String bPw = request.getParameter("bPw");
		String bIp = request.getRemoteAddr();
		
		BoardDto bDto = new BoardDto();
		bDto.setbTitle(bTitle);
		bDto.setmId(mId);
		bDto.setbContent(bContent);
		bDto.setbPw(bPw);
		bDto.setbIp(bIp);
		
		BoardDao bdao = BoardDao.getInstance();
		
		int result = bdao.getInsertBoard(bDto);
		ActionForwad forward = new ActionForwad();
		if(result>0) {
			forward.setPath("/Project_MB/boardList.bo");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return forward;
	}

}
