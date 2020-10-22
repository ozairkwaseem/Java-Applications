<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Football dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Welcome To Football Site</h1>
  <div class="row">
    <div class="col">
      <h4>Login</h4>
      <p>${loginError}</p>
      			<form method="POST" action="/login">
				<div class="form-group">
			    	<label>Email:</label>
			    	<input class="form-control" type="email" name="lemail">
			    </div>
			    <div class="form-group">
			    	<label>Password:</label>
			    	<input class="form-control" type="password" name="lpassword">
			    </div>
			    <button class="btn btn-danger">Login</button>
			</form>
    </div>
    <div class="col">
      			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="owner">
			    <div class="form-group">
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="netWorth">Net Worth</form:label>
			        <form:errors path="netWorth"/>
			       <form:input type="text" class="form-control" path="netWorth"/>
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group">
			        <form:label path="confirmPassword">Confirm Password</form:label>
			        <form:errors path="confirmPassword"/>
			       <form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
			    </div>
			    <input class="btn btn-danger" type="submit" value="Submit"/>
			</form:form>
    </div>
  </div>
</body>
</html>l>