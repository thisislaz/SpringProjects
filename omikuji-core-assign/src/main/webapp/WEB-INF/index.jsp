<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

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
<body class="bg-dark text-white">

	<h1>Send an Omikuji!!</h1>
	<form class="container" action="/showAnswers" method="POST">
		<div id="formId">
			<label>Pick any number from 5 to 25: </label>
			<input class="input-small" type="number" name="numberYears" placeholder="0" min="5" max="25"/>
		</div>
		<div id="formId">
			<label>Enter the name of any city.</label>
			<input class="input-medium" type="text" name="city"/>
		</div>
		<div id="formId">
			<label>Enter the name of any real person.</label>
			<input class="input-medium" type="text" name="person"/>
		</div>
		<div id="formId">
			<label>Enter professional endeavor or hobby.</label>
			<input class="input-medium" type="text" name="hobby"/>
		</div>
		<div id="formId">
			<label>Enter any type of living thing.</label>
			<input class="input-medium" type="text" name="thing"/>
		</div>
		<div id="formId">
			<label>Say something nice:</label>
			<textarea name="nice" id="" cols="30" rows="10"></textarea>
		</div>
		<em>Send and show a friend</em><br />
		<button  class="btn btn-primary">Send</button>
		
		
	</form>



</body>
</html>