<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/layout/header.jsp"/>

<script type="text/javascript">
	 $(function(){
		 $("#changePwBtn").click(function(){
			 if ( $("#mPw").val() == "" ) {
				 alert("패스워드를 입력하세요");
				 $("#mPw").focus();
				 return false;
			 }
			 if ( $("#mPw").val() != $("#mPw2").val() ) {
				 alert("입력한 패스워드를 확인하세요");
				 return false;
			 }
			 $.ajax({
				 url: "/Project_MB/ajaxChangePw.me", 
				 type: "POST",
				 dataType: "text",
				 data: $("#f").serialize(), // 폼을 직렬화해서 보낸다.(폼의 모든 요소를 보낸다.)
				 success: function( data ){
					 if(data.trim() == "SUCCESS") {
						 alert("새로운 비밀번호가 설정되었습니다. 다시 로그인을 해주세요.");
						 location.href = "/Project_MB/loginPage.me"
					 }else {
						 alert("패스워드 변경이 실패했습니다.");
						 history.back();
					 }
				 }, // end success
				 error: function() {
					 alert("실패");
				 }
			 }); // end ajax
		 }); // end click
	 }); // end 페이지로드
</script>
<style type="text/css">
	table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	td {
		border: 1px solid black;
		padding: 5px;
	}
	tfoot {
		text-align: center;
	}
</style>

<div>
	<form method="post" id="f">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						${param.mId }<!-- request로 전달되는 파라미터 -->
						<input type="hidden" name="mId" value="${param.mId }" />
					</td>
				</tr>
				<tr>
					<td>비밀번호 입력</td>
					<td><input type="password" name="mPw" size="30" id="mPw" autofocus /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="mPw2" size="30" id="mPw2" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="비밀번호 변경" id="changePwBtn" />
						&nbsp;&nbsp;
						<input type="button" value="로그인하러 가기" onclick="location.href='/Project_MB/loginPage.me'" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<jsp:include page="/layout/footer.jsp"/>