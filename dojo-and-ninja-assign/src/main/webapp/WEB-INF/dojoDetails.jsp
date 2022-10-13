<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Class</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>

<h1> <c:out value="${ dojo.name }"></c:out> location ninjas</h1>
<a href="/">go back</a>
	
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachNinja" items="${ dojo.ninjas }">
				<tr>
					<td><c:out value="${ eachNinja.firstName }"></c:out></td>
					<td><c:out value="${ eachNinja.lastName }"></c:out></td>
					<td><c:out value="${ eachNinja.age }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>