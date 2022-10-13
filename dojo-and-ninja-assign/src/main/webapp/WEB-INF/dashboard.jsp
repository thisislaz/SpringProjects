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

	<h1>Dashboard</h1>
	<a href="/dojos/new">New Dojo</a> |
	<a href="/ninjas/new"> New Ninja</a> 
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Dojo</th>
				
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachDojo" items="${ dojoList }">
				<tr>
					<td><c:out value="${ eachDojo.id }"></c:out></td>
					<td><a href="/dojos/${ eachDojo.id }"><c:out value="${ eachDojo.name }"></c:out></a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>