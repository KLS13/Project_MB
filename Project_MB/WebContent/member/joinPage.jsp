<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {

	// 1. 아이디 중복체크
	var regExpId = /^[a-z]+[0-9a-z]{4,20}$/;

	$("#mId").keyup(function() {

		$.ajax({
			url : "/Project_MB/ajaxIdCheck.me",
			type : "POST",
			dataType : "json",
			data : "mId=" + $("#mId").val(),
			success : function(jsonObj) {

				var obj = eval(jsonObj);
				// obj["result"] : "result" 키 값에 저장된 value

				if (regExpId.test($("#mId").val())) {
					if (obj["result"] == "YES") {
						$("#idCheckResult").text("이미 사용 중인 아이디입니다.");
						$("#idCheckResult").css("color", "red");
					} else {
						$("#idCheckResult").text("이 아이디는 사용할 수 있습니다.");
						$("#idCheckResult").css("color", "blue");
					}
				} else {
					$("#idCheckResult").text("5~20자, 소문자 시작, 소문자+숫자");
					$("#idCheckResult").css("color", "red");
				}
				
			}, // end success
			error : function() {
				alert("공백없이 입력해주세요.");
			}
		}); // end ajax
	}); // end keyup (end 아이디 중복체크)

	$("#joinBtn").click(function() {
		
		$.ajax({
			url : "/Project_MB/ajaxJoin.me",
			type : "POST",
			dataType : "json",
			data : $("#f").serialize(),
			success : function(data) {
				var obj = eval(data);
				
				if (obj["result"] == "SUCCESS") {
					alert("회원가입이 성공하였습니다.");
					location.href = "/Project_MB/indexPage.me"
				} else {
					alert("회원가입이 실패했습니다.");
					history.back();
				}
			}, // end success
			error : function() {
				alert("공백없이 입력해주세요.");
			}
		}); // end ajax
	}); // end click
	
}); // end 페이지로드
</script>
<form name="joinForm" id="f" method="post">
<table>
	<tr class="join">
		<th class="join">아이디</th>
		<td class="join">
		<input type="text" name="mId" id="mId"/>
		<span id="idCheckResult"></span>
		</td>
	</tr>
	<tr class="join">
		<th class="join">비밀번호</th>
		<td class="join"><input type="password" name="mPw" id="mPw"/>
		<span id="pwCheckResult"></span>
		</td>
	</tr>
	<tr class="join">
		<th class="join">비밀번호 확인</th>
		<td class="join"><input type="password" name="mPw2" id="mPw2"/></td>
	</tr>
	<tr class="join">
		<th class="join">이름</th>
		<td class="join"><input type="text" name="mName" id="mName"/></td>
	</tr>
	<tr class="join">
		<th class="join">닉네임</th>
		<td class="join"><input type="text" name="mNick" id="mNick"/></td>
	</tr>
	
</table>
<button type="button" id="joinBtn" onclick="join(this.form)">회원가입</button>
</form>
  
  
<jsp:include page="/layout/footer.jsp"/>