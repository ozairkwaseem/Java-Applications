<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date and Time</title>
</head>
</head>
<body onload="alertPage('<c:out value="${dt}"/>')">
	<h1 class=<c:out value="${ dt }"/>><c:out value="${ dtFormat }" /></h1>
	<script defer type="text/javascript" src="js/logic.js"></script>
</body>
</html>