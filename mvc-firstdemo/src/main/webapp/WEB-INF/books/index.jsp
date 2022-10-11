<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

	<h1>All Books</h1>
	<table class="table table-dark table-bordered">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody> <!-- loop over all the books to show the details as in the wireframe! -->
	         <c:forEach var="eachBook" items="${ books }">
	         <tr>
	         	<td><c:out value="${ eachBook.id }"></c:out></td>
	         	<td>
	         		
	         		<a href="/books/${ eachBook.id }">
	         			<c:out value="${ eachBook.title }"></c:out>
	         		</a>
	         	</td>
	         	<td><c:out value="${ eachBook.language }"></c:out></td>
	         	<td><c:out value="${ eachBook.numberOfPages }"></c:out></td>
	         </tr>
	         </c:forEach>
	    </tbody>
	</table>
	<a href="/books/new" class="btn btn-primary">Add a new Book</a>
</body>
</html>