package com.project.mb.dto;

public class MemberDto {

	private String mId,mPw,mName,mNick;
	
	

	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MemberDto(String mId, String mPw, String mName, String mNick) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mNick = mNick;
	}



	public String getmId() {
		return mId;
	}



	public void setmId(String mId) {
		this.mId = mId;
	}



	public String getmPw() {
		return mPw;
	}



	public void setmPw(String mPw) {
		this.mPw = mPw;
	}



	public String getmName() {
		return mName;
	}



	public void setmName(String mName) {
		this.mName = mName;
	}



	public String getmNick() {
		return mNick;
	}



	public void setmNick(String mNick) {
		this.mNick = mNick;
	}
}
