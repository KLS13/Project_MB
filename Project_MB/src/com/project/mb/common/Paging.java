package com.project.mb.common;

public class Paging {

	public static String getPaging(String path, int nowPage, int recordPerPage, int totalRecord) {
		
		StringBuffer sb = new StringBuffer();
		
		// nowPage : 현재 페이지 번호
		// recordPerPage : 한 페이지에 표시할 레코드(회원, 게시글) 개수
		// totalRecord : 전체 레코드 개수
		int totalPage = 0; // 전체 페이지 개수
		int beginPageOfBlock = 0; // 블록의 시작 페이지 번호
		int endPageOfBlock = 0; // 블록의 끝 페이지 번호
		int pagePerBlock = 5; // 한 블록에 표시할 페이지 개수
		
		// 전체 레코드 개수와 한 페이지에 표시할 레코드 개수를 알면
		// 전체 페이지 개수를 알 수 있다.
		totalPage = (int)(totalRecord / recordPerPage);
		if ( totalRecord % recordPerPage != 0 ) {
			totalPage++;
		}
		
		// totalPage 조정 (잘못된 연산/이동 대비용)
		if ( nowPage > totalPage ) {
			totalPage = nowPage;
		}
		
		// 블록에 표시할 시작 페이지 번호와 끝 페이지 번호 계산
		beginPageOfBlock = (int)(((nowPage - 1) / pagePerBlock) * pagePerBlock) + 1;
		endPageOfBlock = beginPageOfBlock + pagePerBlock - 1;
		
		// endPageOfBlock 조정 (자주 발생)
		if ( endPageOfBlock > totalPage ) {
			endPageOfBlock = totalPage;
		}
		
		// 이전 버튼 표시
		// 이전 버튼의 링크 필요 유무에 따라 if 처리
		// 1. 이전 버튼의 링크가 필요 없는 경우 : beginPageOfBlock < pagePerBlock
		// 2. 이전 버튼의 링크가 필요한 경우
		if ( beginPageOfBlock < pagePerBlock ) {
			sb.append("<span style='color:gray;'>◀</span>&nbsp;&nbsp;");
		} else {
			sb.append("<a href='" + path + "?currentPage=" + (beginPageOfBlock - 1) + "'>◀</a>&nbsp;&nbsp;");
		}
		
		// 페이지 번호 표시
		// 페이지 번호의 링크 필요 유무에 따라 if 처리
		// 1. 페이지 번호의 링크가 필요 없는 경우 : page == nowPage
		// 2. 페이지 번호의 링크가 필요한 경우
		for ( int page = beginPageOfBlock; page <= endPageOfBlock; page++ ) {
			if ( page == nowPage ) {
				sb.append("<span style='color: lightgray;'>" + page + "</span>&nbsp;&nbsp;");
			} else {
				sb.append("<a href='" + path + "?currentPage=" + (page) + "'>" + page + "</a>&nbsp;&nbsp;");
			}
		}
		
		// 다음 버튼 표시
		// 다음 버튼의 링크 필요 유무에 따라 if 처리
		// 1. 다음 버튼의 링크가 필요 없는 경우 : endPageOfBlock == totalPage
		// 2. 다음 버튼의 링크가 필요한 경우
		if ( endPageOfBlock == totalPage ) {
			sb.append("<span style='color: gray;'>▶</span>");
		} else {
			sb.append("<a href='" + path + "?currentPage=" + (endPageOfBlock + 1) + "'>▶</a>");
		}
		
		return sb.toString();
		
	}
	
}
