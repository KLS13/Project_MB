<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/layout/header.jsp"/>
<link rel="stylesheet" type="text/css" href="/Project_MB/board/board.css">

<table class="board">
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="5">작성된 게시글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="bDto" items="${list }">
					<tr>
						<td>${bDto.bIdx }</td>
						<td style="text-align: left;">
							<!-- 1. 댓글과 원글 구분을 위해 bDepth만큼 들여쓰기를 진행한다. -->
							<c:forEach begin="1" end="${bDto.bDepth }" step="1">
								&nbsp;&nbsp;
							</c:forEach>
							<!-- 2. 댓글은 제목 앞에 [Re] 표시 -->
							<c:if test="${bDto.bDepth ne 0 }">
								[Re]
							</c:if>
							<!-- 3. 삭제 여부에 따른 표시 구분 -->
							<c:if test="${bDto.bDelete eq 0 }">
								<a href="/Project_MB/boardViewPage.bo?bIdx=${bDto.bIdx }&currentPage=${currentPage }" class="list_a">${bDto.bTitle }</a>
							</c:if>
							<c:if test="${bDto.bDelete eq -1 }">
								${bDto.bTitle }
							</c:if>
						</td>
						<td>${bDto.mId }</td>
						<td>${bDto.bPostDate }</td>
						<td>${bDto.bHit }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">${pagingView }</td>
		</tr>
	</tfoot>
</table>

<br /><br />

<!-- 로그인 된 사용자는 게시글을 작성할 수 있다. -->
<c:if test="${sessionScope.loginDto ne null }">
	<input type="button" value="게시글 작성하기" onclick="location.href='/Project_MB/boardWritePage.bo?currentPage=${currentPage }'" />
	<input type="button" value="내 게시글 보기" onclick="location.href='/Project_MB/myBoardList.bo?currentPage=${currentPage }'" />
	<input type="button" value="전체 게시글 보기" onclick="location.href='/Project_MB/boardList.bo?currentPage=${currentPage }'" />
</c:if>

<jsp:include page="/layout/footer.jsp"/>