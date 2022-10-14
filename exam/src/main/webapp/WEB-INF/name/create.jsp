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

		<h1>Add a name!</h1>
		<form:form action="/name/new" method="post"
			modelAttribute="name">
			<div>
				<form:label path="name"> Name</form:label>
				<form:input type="text" path="name" />
				<form:errors path="name" />
			</div>
			<div>
				<form:label path="owner"> Gender </form:label>
				<form:select path="owner">

					<c:forEach var="eachGender" items="${ gender }">

						<form:option value="${ eachGender.id }"> ${ eachGender.gender } </form:option>

					</c:forEach>

				</form:select>

			</div>
			<div>
				<form:label path="origin"> Origin</form:label>
				<form:input type="text" path="origin" />
				<form:errors path="origin" />
			</div>
			<div>
				<form:label path="meaning"> Meaning</form:label>
				<form:textarea path="meaning" />
				<form:errors path="meaning" />
			</div>
			<a class="btn btn-primary" href="/dashboard">Cancel</a>
			<button type="submit">Submit</button>
		</form:form>

	</div>
</body>
</html>