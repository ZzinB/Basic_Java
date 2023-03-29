<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycom.myapp.board.BoardDAO, com.mycom.myapp.board.BoardVO"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 화면 샘플 - Bootstrap</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}

</style>
</head>
<body>
	<div class="container">
		
		<div class="input-form-backgroud row">

			<div class="input-form col-md-12 mx-auto">
			<input type="button" value="이전" onclick="location.href='./login'"
			style="border: none; background-color: #92b5db; border-radius: 5px; color:white; "/>
			<h2 class="mb-3"> </h2>
				<h3 class="mb-3"><b>회원가입</b></h3>

				<form action="./registerok" method="post">
					<div id="edit">
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="Student ID">Student ID</label> <input type="text"
									class="form-control" name="uid" id="Student I" placeholder="Student ID"
									value="" required>
								<div class="invalid-feedback">Student ID를 입력해주세요.</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="Name">Name</label> <input type="text"
									class="form-control" name="uname" id="Name" placeholder="Name"
									value="" required>
								<div class="invalid-feedback">Name 입력해주세요.</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="Id">Id</label> <input type="text"
									class="form-control" name="id" id="id" placeholder="Id"
									required>
								<div class="invalid-feedback">Id 입력해주세요.</div>
							</div>
							<div class="col-md-6 mb-3">
								<label for="Password">Password</label> <input type="password"
									class="form-control" name="password" id="password"
									placeholder="Password" required>
								<div class="invalid-feedback">Password 입력해주세요.</div>
								
							</div>
						</div>
					</div>
					<button class="btn btn-primary btn-lg btn-block" type="submit">가입
						완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
