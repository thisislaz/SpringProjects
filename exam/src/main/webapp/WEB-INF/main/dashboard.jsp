<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

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
	<div class="container mt-5">
		<div class="d-flex justify-content-space-between align-items-center">
			<h1 class="d-inline-block ">Hello, ${user.name }. Here are some
				name suggestions.</h1>
			<a href="/logout">log out</a>
		</div>

		<table class="table table-dark table-striped">

			<tbody>

				<c:forEach var="name" items="${ allNames }">
					<tr>
						
						<td><c:out value="${ name.name }"></c:out></td>
						<td><c:out value="${ name.gender }"></c:out></td>
						<td><c:out value="Orgin: ${ name.meaning }"></c:out></td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<a href="/name/new">new name</a>
		</div>

	</div>
</body>
</html>