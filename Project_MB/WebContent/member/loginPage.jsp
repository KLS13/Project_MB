<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<jsp:include page="/layout/header.jsp"/>
<form action="/Project_MB/login.me" method="post">

<table class="login">
	<tr class="login">
		<th class="login">아이디</th>
		<td class="login"><input type="text" id="mId" name="mId"></td>
	</tr>
	<tr class="login">
		<th class="login">비밀번호</th>
		<td class="login"><input type="password" id="mPw" name="mPw"></td>
	</tr>
</table>
<br />
<input type="submit" value="로그인"/>

</form>
<jsp:include page="/layout/footer.jsp"/>