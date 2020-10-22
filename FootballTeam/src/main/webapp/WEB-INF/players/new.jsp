
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Player</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<form:form method="POST" action="/players/new" modelAttribute="player">
	<div class="form form-group">
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
	<div class="form form-group">
	<form:label path="position">Position:
	<form:errors path="position"/>
	<form:input path="position"/></form:label>
	</div>
	<div class="form form-group">
	<form:label path="weight">Weight:
	<form:errors path="weight"/>
	<form:input path="weight"/></form:label>
	</div>
	
	<form:errors path="team"/>
	<form:select path="team">
	<c:forEach items="${team}" var="team">
	<option value="${team.id}">${team.name }</option>
	</c:forEach>
	</form:select>

	<button>Add Player</button>
</form:form>

</body>
</html>