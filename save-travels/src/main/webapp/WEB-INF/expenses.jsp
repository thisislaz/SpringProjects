<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Java Class</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="top-half">
	<h1>Save Travels</h1>
	<table class="table table-dark table-bordered">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachExpense" items="${ expenses }">
			<tr>
				<td><c:out value="${ eachExpense.expenseName }"></c:out></td>
				<td><c:out value="${ eachExpense.vendor }"></c:out></td>
				<td><c:out value="$ ${ eachExpense.amount }"></c:out></td>
				<td><a href="/expenses/edit/${eachExpense.id}">Edit</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
	<div id="bot-half">
	<h2>Add an expense:</h2>
	<form:form action="/expenses" method="POST" modelAttribute="expense">
		<div >
			<form:label class="d-block" path="expenseName">Expense Name: </form:label>
			<form:errors path="expenseName" class="text-danger"/>
			<form:input type="text" path="expenseName" />
		</div>
		<div>
			<form:label class="d-block" path="vendor">Vendor</form:label>
			<form:errors path="vendor" class="text-danger"/>
			<form:input type="text" path="vendor" />
		</div>
		<div>
			<form:label class="d-block" path="amount">Amount</form:label>
			<form:errors path="amount" class="text-danger"/>
			<form:input type="text" path="amount" />
		</div>
		<div>
			<form:label class="d-block" path="description">Description</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" id="" cols="30" rows="5"></form:textarea>
		</div>
		<input class="btn btn-success" type="submit" value="Submit"/>
	</form:form>
	</div>

</body>
</html>