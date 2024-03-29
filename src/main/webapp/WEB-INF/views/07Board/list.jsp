<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	
	<h2>비회원제 답변형 게시판</h2>
	<h3>전체페이지:${totalPage } / 현재페이지:${nowPage }</h3>

	<!-- 검색폼 -->
	<form method="get">
	<table border="1" width="90%">
	<tr>
		<td align="center">
			<select name="searchColumn">
				<option value="title">제목</option>
				<option value="contents">내용</option>
			</select>
			<input type="text" name="searchWord" />
			<input type="submit" value="검색하기" />
		</td>
	</tr>	
	</table>	
	</form>
	
	<!-- 글쓰기버튼 -->
	<table border="1" width="90%">
		<tr>
			<td align="right">
				<button type="button" 
				onclick="location.href='./write.do';">글쓰기</button>
			</td>
		</tr>
	</table>
	
	<!-- table>tr*2>td*5 -->
	<table border="1" width="90%">
		<tr>
			<th width="10%">번호</th>
			<th width="*">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">작성일</th>
			<th width="15%">조회수</th>
			<!-- <th width="5%">첨부</th> -->
		</tr> 
		<c:choose>
			<c:when test="${empty listRows }">
				<tr>
					<td colspan="6" class="text-center">
						등록된 게시물이 없습니다 ^^*
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${listRows }" var="row" 
					varStatus="loop">
					<!-- 리스트반복시작 -->
					<tr>
						<td class="text-center">${row.virtualNum }</td>
						<td class="text-left">
							<a href="./view.do?idx=${row.idx}
								&nowPage=${nowPage}">${row.title}</a>
						</td>
						<td class="text-center">${row.name }</td>
						<td class="text-center">${row.postdate }</td>
						<td class="text-center">${row.hits }</td>
						<!-- <td class="text-center">--</td> -->
					</tr>
					<!-- 리스트반복끝 -->
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<!-- 페이지 번호 -->
	<table border="1" width="90%">
		<tr>
			<td align="center">
				${pagingImg }
			</td>
		</tr>
	</table>
</div>

</body>
</html>