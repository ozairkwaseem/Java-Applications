<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>Add Team</h2>
<hr>
<form:form method="POST" action="/teams/team" modelAttribute="team">
	<p>
	<form:label path="name">Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</p>
	
	<p>
	<form:label path="city">City:
	<form:errors path="city"/>
	<form:input path="city"/></form:label>
	</p>
	<p>
	<form:label path="players"># Of Players
	<form:errors path="players"/>
	<form:input path="players"/></form:label>
	</p>
	<button>Add Team</button>
</form:form>

<!--
OLD WAY USING STAMDARD FORMS
<c:forEach items="${errors}" var="err">
${err}
</c:forEach>
<form action="/new" method="POST">
<div class="form-group">
<label for="name">Name</label>
<input type="text" name="name">
</div>
<div class="form-group">
<label for="name">City</label>
<input type="text" name="city">
</div>
<div class="form-group">
<label for="name">Players</label>
<input type="text" name="players">
</div>
<button>Add Team</button>
</form>
-->
</div>

</div>
</body>
</html>