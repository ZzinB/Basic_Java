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
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deleteok/' + id;
	}
</script>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6" style="margin-left:25%;">
						<div class="jumbotron text-center">	
						<h2>
							CarSharing <b>Room</b>
							<p>환영합니다. [${login.uname}]님.</p>
						</h2>
						</div>
					</div>
					<div class="col-sm-6" style="float:right">
					       <ul class="nav navbar-nav navbar-right">
					
						<a href="../login/logout" class="btn btn-danger"
							data-toggle="modal"> <span>Log
								out</span></a>
						<a href="./editUser/${login.uid}" class="btn btn-info"
							data-toggle="modal"> <span>회원정보수정</span></a>
							       </ul>
							
					</div>
				</div>
			</div>
			<button type="button" onclick="location.href='makeRoom/${login.uid}'" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
								Room</span></button> 
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>방번호</th>
						<th>인원</th>
						<th>내용
						</th>
					</tr>

				</thead>
				<tbody>

					<c:forEach items="${list}" var="u">
						<tr>
							<td>${u.room_num}</td>
							<td>${u.room_count}</td>
							<td>${u.room_contents}</td>
							<td><a href="./enter/${u.room_num}/${login.uid}">방입장</a></td>
						</tr>
					</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>
