<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Project Manager Dashboard</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<div class="d-flex justify-content-between align-items-center">
			<h1 class="d-inline-block">Namaste,<c:out value=" ${ user.userName }." /></h1>
			<a class="btn btn-danger" href="/logout">logout</a>
		</div>
		<p>Course Schedule</p>
		<table class="table table-dark table-striped">
	
			
			<thead>
				<tr>
					<th>Course Name</th>
					<th>Instrutor</th>
					<th>Weekday</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachCourse" items="${ courseList }">
					<tr>
						
						<td><a href="/courses/${ eachCourse.id }">${ eachCourse.courseName }</a>
							<c:if test="${ userId.equals(eachCourse.instructor.id) }">
								<a class="btn btn-sm btn-warning" href="/courses/edit/${ eachCourse.id }">edit</a>
							</c:if>
						</td>
						
						
						<td><c:out value=" ${ eachCourse.instructor.userName }"/></td>
						<td><c:out value=" ${ eachCourse.weekDay }"/> </td>
						<td><c:out value="$${ eachCourse.price }"/>	</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		<a class="btn btn-success" href="/courses/add">+ new course</a>
		
	</div>
</body>
</html>