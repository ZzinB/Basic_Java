<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.mycom.myapp.board.BoardDAO, com.mycom.myapp.board.BoardVO"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원수 화면 샘플 - Bootstrap</title>
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
#input_group {
	margin-right: -30px;
	padding: 10px;
	text-align: center;
}
</style>
</head>

<body>
	<div class="container">

		<div class="input-form-backgroud row">

			<div class="input-form col-md-12 mx-auto">
				<h2 class="mb-3"></h2>
				<h3 class="mb-3" style = "margin-left:43%">
					<b>방 만들기</b>
				</h3>

	
<form action="../makeok" method="post">
	<table id="edit">
	<tr><td><input type="hidden" name="room_master" value="${id}"/></td></tr>
	<tr><td>Contents:</td><td><textarea cols="60" rows="5" name="room_contents"></textarea></td></tr>
	</table>
		<div id="input_group">
			<input type="submit" value="방만들기"
							style="border: none; background-color: #92b5db; border-radius: 5px; color: white;" />
			<input type="button" value="취소하기" onclick="location.href='../list'" style="border:none;background-color: #92b5db; border-radius: 5px; color: white;"/>
		</div>
</form>

</body>
</html>