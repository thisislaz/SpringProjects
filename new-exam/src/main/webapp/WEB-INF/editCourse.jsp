
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
	<div class="container mt-5">
	
		<h1><c:out value="${ course.courseName }"/></h1>
		<form:form method="post" action="/courses/edit/${ course.id }" modelAttribute="course">
		<input type="hidden" name="_method" value="put" />
			<div>
				<form:label path="courseName"> Name </form:label>
				<form:input type="text" path="courseName" />
				<form:errors path="courseName" />
			</div>
			<div>
				<form:label path="weekDay"> Day of Week</form:label>
				<form:input type="text" path="weekDay" />
				<form:errors path="weekDay" />
			</div>
			<div>
				<form:label path="price"> Drop-in Price </form:label>
				<form:input type="number" path="price" />
				<form:errors path="price" />
			</div>
			<div>
				<form:label path="description"> Description </form:label>
				<form:textarea path="description"></form:textarea>
				<form:errors path="description"/>
			</div>
					<a class="btn btn-warning" href="/courses"> Cancel </a>
					<button class="btn btn-success" type="submit">Submit</button>
					<form:hidden path="instructor" />
			</form:form>
			<form method="post" action="/courses/delete/${ course.id }">
				<input type="hidden" name="_method" value="delete" />
				<button class="btn btn-danger" >Delete</button>
			</form>
			
				
				
				
					
			
		
	
	</div>
</body>
</html>
			
				