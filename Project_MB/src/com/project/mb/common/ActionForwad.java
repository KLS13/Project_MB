package com.project.mb.common;

public class ActionForwad {
	//이동경로(view) + 이동방법 ( 리다이렉트 , 포워드 )
	
	private boolean isRedirect = false;  // 기본값은 forward  ( 리다이렉트는 false 니까 )
	private String path = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
