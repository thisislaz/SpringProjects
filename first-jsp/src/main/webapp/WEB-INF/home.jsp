<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div>
		<h1>Home.jsp</h1>
		<h2> <c:out value="${name}"></c:out></h2>
		<h2>Two plus two is: </h2>
		<h2><c:out value="${2+2}"/></h2>
	</div>
</body>
</html>