<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/layout/header.jsp"/>

<script type="text/javascript">
	
	$(function(){
		$("#searchPwBtn").click(function(){
			if ( $("#mId").val() == "" ) {
				alert("아이디를 입력하세요");
				$("#mId").focus();
				return false;
			}
			if ( $("#mNick").val() == "" ) {
				alert("가입에 기입한 닉네임을 입력하세요");
				$("#mNick").focus();
				return false;
			}
			$.ajax({
				url: "/Project_MB/ajaxSearchPw.me",
				type: "POST",
				dataType: "text",
				data: "mId=" + $("#mId").val() + "&mNick=" + $("#mNick").val(),
				success: function(data){
					if ( data.trim() == "YES" ) {
						alert("회원님의 정보가 확인되었습니다. 새로운 패스워드를 설정하세요.");
						location.href = "/Project_MB/changePwPage.me?mId=" + $("#mId").val();
					} else {
						alert("회원님의 정보가 없습니다.");
					}
				}, // end success
				error: function(){
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
	<form method="post">
		<table>
			<tbody>
				<tr>
					<td>아이디 입력</td>
					<td><input type="text" name="mId" size="30" id="mId" /></td>
				</tr>
				<tr>
					<td>닉네임 입력</td>
					<td><input type="text" name="mNick" size="30" id="mNick" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="비밀번호 찾기" id="searchPwBtn" />
						&nbsp;&nbsp;
						<input type="button" value="로그인하러 가기" onclick="location.href='/Project_MB/loginPage.me'" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<jsp:include page="/layout/footer.jsp"/>