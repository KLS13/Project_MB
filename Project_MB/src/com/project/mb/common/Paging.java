package com.project.mb.common;

public class Paging {

	public static String getPaging(String path, int nowPage, int recordPerPage, int totalRecord) {
		
		StringBuffer sb = new StringBuffer();

		int totalPage = 0; 
		int beginPageOfBlock = 0; 
		int endPageOfBlock = 0; 
		int pagePerBlock = 5; 
		
		totalPage = (int)(totalRecord / recordPerPage);
		if ( totalRecord % recordPerPage != 0 ) {
			totalPage++;
		}
		
	
		if ( nowPage > totalPage ) {
			totalPage = nowPage;
		}
		
		beginPageOfBlock = (int)(((nowPage - 1) / pagePerBlock) * pagePerBlock) + 1;
		endPageOfBlock = beginPageOfBlock + pagePerBlock - 1;
		
		if ( endPageOfBlock > totalPage ) {
			endPageOfBlock = totalPage;
		}
		
		if ( beginPageOfBlock < pagePerBlock ) {
			sb.append("<span style='color:gray;'>◀</span>&nbsp;&nbsp;");
		} else {
			sb.append("<a href='" + path + "?currentPage=" + (beginPageOfBlock - 1) + "'>◀</a>&nbsp;&nbsp;");
		}
		
		for ( int page = beginPageOfBlock; page <= endPageOfBlock; page++ ) {
			if ( page == nowPage ) {
				sb.append("<span style='color: lightgray;'>" + page + "</span>&nbsp;&nbsp;");
			} else {
				sb.append("<a href='" + path + "?currentPage=" + (page) + "'>" + page + "</a>&nbsp;&nbsp;");
			}
		}

		if ( endPageOfBlock == totalPage ) {
			sb.append("<span style='color: gray;'>▶</span>");
		} else {
			sb.append("<a href='" + path + "?currentPage=" + (endPageOfBlock + 1) + "'>▶</a>");
		}
		
		return sb.toString();
		
	}
	
}
