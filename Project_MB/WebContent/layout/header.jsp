<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>미니 프로젝트</title>
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="/Project_MB/layout/layout.css">
		<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	</head>
	<body>
		<div align = "center">
			<div class = "header" align = "center">
			<a onclick="location.href='/Project_MB/indexPage.me'">홈</a> |
			<c:if test="${empty sessionScope.loginDto}">
			<a onclick="location.href='/Project_MB/joinPage.me'">회원가입</a> |
			<a onclick="location.href='/Project_MB/loginPage.me'">로그인</a> |
			</c:if> 
			<a onclick="location.href='/Project_MB/boardList.bo'">게시판</a>
			<c:if test="${!empty sessionScope.loginDto}">
			| <a onclick="location.href='/Project_MB/logout.me'">로그아웃</a>
			<div align="right">
			${sessionScope.loginDto.mId }님 반갑습니다.
			<a onclick="location.href='/Project_MB/myPage.me'">[마이페이지]</a>
			<a onclick="location.href='/Project_MB/donation.me'">[후원하기]</a>
			</div>
			</c:if>
			</div>
			<div class="main" align="center">
			

