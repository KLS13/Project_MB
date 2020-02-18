package com.project.mb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// public String execute(HttpServletRequest request, HttpServletResponse response);   기존 액션
	 public ActionForwad execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
