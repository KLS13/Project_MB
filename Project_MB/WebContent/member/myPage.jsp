<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/layout/header.jsp"/>
<link rel="stylesheet" type="text/css" href="/Project_MB/layout/des.css">
<script type="text/javascript">
	
	$(function(){
		
		// 1. 회원정보수정
		$("#updateMemberBtn").click(function(){
			$.ajax({
				url: "/Project_MB/ajaxUpdate.me",
				type: "POST",
				dataType: "json",
				data: $("#f").serialize(), // 직렬화: mId=mId&mPw=mPw&...
				success: function( jsonObj ) {
					var obj = eval( jsonObj );
					if ( obj["result"] == "SUCCESS" ) {
						alert("회원정보가 수정되었습니다.");
						location.href = "/Project_MB/indexPage.me";
					} else {
						alert("회원정보가 수정되지 않았습니다.");
						location.href = "/Project_MB/myPage.me";
					}
					
				}, // end success
				error: function(){
					alert("실패");
				}
			}); // end ajax
		}); // end click (end 회원정보수정)
		
		// 2. 회원비밀번호 수정
		$("#updatePwBtn").click(function(){
			location.href = "/Project_MB/changePwPage.me?mId=" + $("#mId").val();
		});
		
		
	}); // end 페이지로드
	
</script>

<div>
	<h1>회원 정보</h1>
    <form method="post" id="f">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						${loginDto.mId }
						<input type="hidden" name="mId" id="mId" value="${loginDto.mId }" />
					</td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input type="text" name="mName" id="mName" value="${loginDto.mName }" /></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="mNick" id="mNick" value="${loginDto.mNick }" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="회원정보수정" id="updateMemberBtn" />
						<input type="button" value="비밀번호수정" id="updatePwBtn" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>
 
<jsp:include page="/layout/footer.jsp"/>