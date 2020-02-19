package com.project.mb.model.board;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.mb.common.Action;
import com.project.mb.common.ActionForwad;
import com.project.mb.dao.BoardDao;
import com.project.mb.dto.BoardDto;

public class ReplyInsertAction implements Action {

	@Override
	public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int bIdx = Integer.parseInt(request.getParameter("bIdx"));
		String currentPage = request.getParameter("currentPage");
		
		String bTitle = request.getParameter("bTitle");
		String mId = request.getParameter("mId");
		String bContent = request.getParameter("bContent");
		String bPw = request.getParameter("bPw");
		String bIp = request.getRemoteAddr();
		
		BoardDto subDto = new BoardDto();
		subDto.setbTitle(bTitle);
		subDto.setmId(mId);
		subDto.setbContent(bContent);
		subDto.setbPw(bPw);
		subDto.setbIp(bIp);
		
		BoardDao bDao = BoardDao.getInstance();
		//댓글이 달리는 원글 가져오기
		BoardDto bDto = bDao.getBoardBybIdx(bIdx);
		//원글의 정보를 이용해서 댓글의 정보 작성
		subDto.setbRef(bDto.getbRef());
		subDto.setbStep(bDto.getbStep() + 1);
		subDto.setbDepth(bDto.getbDepth() + 1);
		
		//기존 댓글들의 bStep 증가
		bDao.getUpdateStep(bDto);
		
		ActionForwad forward = new ActionForwad();
		int result = bDao.getInsertReply(subDto);
		if(result > 0) {
			forward.setPath("/Project_MB/boardList.bo?currentPage=" + currentPage);
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=utf-8");
			BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
			bout.write("<script type='text/javascript'>");
			bout.write("alert('댓글 등록 실패')");
			bout.write("history.back()");
			bout.write("</script>");
			bout.close();
		}
		
		return forward;
	}

}
