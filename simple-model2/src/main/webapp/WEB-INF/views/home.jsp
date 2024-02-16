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
<title>모델2 홈 - 20240215</title>
</head>
<body>
<!-- c:set : 속성으로 값을 저장하는 태그 -->
<!--
	include 지시어를 통해
	home.jsp + navbar.jsp가 합쳐진 하나의 jsp 객체가 생성됨 (home_jsp.java)
 -->
<c:set var="menu" value="홈" />
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3 mt-3">
		<div class="col-12">
			<h1 class="mb-3">홈</h1>
		</div>
	</div>
</div>
</body>
</html>