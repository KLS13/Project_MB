package com.project.mb.dto;

import java.sql.Date;

public class BoardDto {

	//bRef, bStep, bDepth
	/*
	 1. 안녕하세요.				bRef = 1, bStep = 0, bDepth = 0
	 	[Re] 반갑습니다.		bRef = 1, bStep = 1, bDepth = 1
	 	[Re] 환영합니다.		bRef = 1, bStep = 2, bDepth = 1
	 		[Re] 님도 환영~~!	bRef = 1, bStep = 3, bDepth = 2
	 		
	 2. 안녕.					bRef = 2, bStep = 0, bDepth = 0
	 	[Re] ㅎㅇ				bRef = 2, bStep = 1, bDepth = 1
	 		[Re] 대댓글		bRef = 2, bStep = 2, bDepth = 2
	 	[Re] 댓글~~~			bRef = 2, bStep = 3, bDepth = 1
	 		
	*/
	private int bIdx, bHit, bRef, bStep, bDepth, bDelete;
	private Date bPostDate;
	private String mId, bTitle, bContent, bPw, bIp;

	public BoardDto() {

	}
	
	public int getbIdx() {
		return bIdx;
	}
	public void setbIdx(int bIdx) {
		this.bIdx = bIdx;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbRef() {
		return bRef;
	}
	public void setbRef(int bRef) {
		this.bRef = bRef;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
	public int getbDelete() {
		return bDelete;
	}
	public void setbDelete(int bDelete) {
		this.bDelete = bDelete;
	}
	public Date getbPostDate() {
		return bPostDate;
	}
	public void setbPostDate(Date bPostDate) {
		this.bPostDate = bPostDate;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getbPw() {
		return bPw;
	}
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	public String getbIp() {
		return bIp;
	}
	public void setbIp(String bIp) {
		this.bIp = bIp;
	}

}