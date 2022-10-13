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

	<h1>New Ninja</h1>
	<a href="/">go back</a>
	<form:form action="/ninjas/new" method="post"
		modelAttribute="ninja">
		<div>
			<form:label path="dojo"> Dojo: </form:label>
			<form:select path="dojo">
				
				<c:forEach var="eachDojo" items="${ dojoList }">
					
					<form:option value="${ eachDojo.id }"> ${ eachDojo.name } </form:option>

				</c:forEach>
				
			</form:select>

		</div>
		
		<div>
			<form:label path="firstName"> First Name: </form:label>
			<form:input type="text" path="firstName" />
			<form:errors path="firstName" />
		</div>
		<div>
			<form:label path="lastName"> Last Name: </form:label>
			<form:input type="text" path="lastName" />
			<form:errors path="lastName" />
		</div>
		<div>
			<form:label path="age"> Age: </form:label>
			<form:input type="number" path="age" />
			<form:errors path="age" />
		</div>
		
		<button type="submit">Create</button>
	</form:form>

</body>
</html>