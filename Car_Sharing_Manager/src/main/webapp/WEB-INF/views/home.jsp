<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
	<title>SignIn Page</title>
</head>
<body>
<h1>
	Sign In Page  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<P> <a href="./board/list">게시판으로 이동</a> </P>
</body>
</html>
