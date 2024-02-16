<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>모델2 - 20240215</title>
</head>
<body>
<!-- c:set : 속성으로 값을 저장하는 태그 -->
<c:set var="menu" value="게시판" />
<!-- include 지시어 -->
<%@ include file="../common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>게시글 목록</h1>
			
			<%-- ${boardList } --%>
			<!-- 해당 jsp에서 boardList를 사용할 수 있는 원리 : BoardController에 boardList라는 이름으로 담겨있음 -->
			<!--
				param.page : (tomcat 안의 jsp 안에서 표현되는)요청파라미터에서 page라는 속성명의 값을 가져옴
				* 요청파라미터값이 비어있을 때는 default=""로 기본값 지정 가능
			-->
			<p>현재 페이지 : <c:out value="${param.page }" default="1"></c:out></p>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>조회수</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty boardList }">
							<tr>
								<td colspan="5" class="text-center">데이터가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="board" items="${boardList }">
								<tr>
									<td>${board.no }</td>
									<td>${board.title }</td>
									<td>${board.readCount }</td>
									<td>${board.user.name }</td>
									<td><ftn:formatDate value="${board.createdDate }"/></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="row mb-3">
		<div class="col-12">
			<nav>
				<ul class="pagination justify-content-center">
					<!-- 2. var begin end 용법 -->
					<c:forEach var="num" begin="1" end="5">
						<!-- eq : EL연산자, A eq B : A가 B와 같다 -->
						<li class="page-item ${param.page eq num ? 'active' : '' }">
							<a href="list.do?page=${num }" class="page-link">${num }</a>
						</li>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</div>
</body>
</html>