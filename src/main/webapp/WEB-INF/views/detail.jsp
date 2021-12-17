<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycom.myapp.board.BoardDAO, com.mycom.myapp.board.BoardVO, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://localhost/weblayout/tablestyle.css">
<style>
.jumbotron {
	background-color: #34495e;
	color: #ffffff;
	padding: 100px 25px;
	text-align: center;
}
</style>
<script>
	function delete_ok(send_id, recv_id) {
		var a = confirm("정말로 삭제하겠습니까?");
		if (a)
			location.href = '../../deleteok/' + send_id + '/' + recv_id;
	}

	function pay_ok(send_id, recv_id) {
		var a = confirm("입금 완료?");
		if (a)
			location.href = '../../payok/' + send_id + '/' + recv_id;
	}
</script>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6" style="margin-left: 25%;">
						<div class="jumbotron text-center">
							<h2>
								<b>Room</b>
								<p>
									환영합니다. [${login.uname}]님! [${num}]번방입니다.</p>
							</h2>
						</div>
					</div>
				</div>
			</div>
			<button type="button"
				onclick="location.href='../../roomok/${login.uid}'"
				class="btn btn-success" data-toggle="modal">
				<span>완료 및 방 삭제</span>
			</button>
			<a href="../../list"class="btn btn-info"
							data-toggle="modal"> <span>방 목록 보기</span></a>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>블랙횟수</th>
						<th>입금여부</th>
						<th>추방</th>
					</tr>

				</thead>
				<tbody>

					<c:forEach items="${ulist}" var="ul">
						<tr>
							<td>${ul.uid}</td>
							<td>${ul.uname}</td>
							<td>${ul.black}</td>
							<td><a href="javascript:pay_ok(${login.uid},${ul.uid})">입금완료</a></td>
							<td><a href="javascript:delete_ok(${login.uid},${ul.uid})">추방</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>
</html>