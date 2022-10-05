<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>

	<h1>Hello World!!</h1>
	
		<% for(int i = 0;i <10;i++){%>
		<button><%= i %></button>
		<%} %>
		
		<h2>The time is: <%= new Date() %></h2>
		
</body>
</html>