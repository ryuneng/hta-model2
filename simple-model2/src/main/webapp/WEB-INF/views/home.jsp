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
	<div class="container">
		<div class="row mb-3 mt-3">
			<div class="col-12">
				<h1 class="mb-3">홈</h1>
				<div>
					<a href="login.do" class="btn btn-outline-primary">로그인</a>
					<a href="logout.do" class="btn btn-outline-primary">로그아웃</a>
					<a href="register.do" class="btn btn-outline-primary">회원가입</a>
				</div>
				<div>
					<!-- 
						현재 주소
							localhost/home.do
						기준 주소
							localhost/
						요청할 주소
							localhost/board/list.do
						링크에 정의할 주소
							<a href="board/list.do">
					 -->
					<a href="board/list.do" class="btn btn-outline-primary">게시판</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>