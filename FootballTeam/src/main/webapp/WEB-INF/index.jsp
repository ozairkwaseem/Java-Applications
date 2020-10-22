<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Football dot Com</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Welcome to Football dot Com</h1>
Logged In As: <c:out value="${owner.firstName} - ${owner.lastName}"/>
<hr>
<a href="/teams/add">Add a New Team</a> | <a href="/players">Add Player To Team</a>
<table class="table table-dark">
<thead>
<th>Action</th>
<th>Name</th>
<th>City</th>
<th>Number of Players</th>
<th>Mascot</th>
<th>Number Of Likes</th>
</thead>
<tbody>

<c:forEach items="${allTeams}" var="team">
<tr>
<td>
<c:choose>
<c:when test="${team.likers.contains(owner.id)}">
Liked!
</c:when>
<c:otherwise>

<td><a href="/teams/like/${team.id}">Like</a></td>
</c:otherwise>
</c:choose>
</td>
<td><a href="teams/${team.id}">${team.name }</a></td>
<td>${team.city}</td>
<td>${team.players }</td>
<td>
<c:choose>
<c:when test="${team.mascot != null}">

${team.mascot.color} ${team.mascot.name}
</c:when>
<c:otherwise>
Does Not Have Mascot\
</c:otherwise>
</c:choose>
</td>
<td>${team.likers.size()}</td>
</tr>
</c:forEach>

</tbody>
</table>



</div>
</body>
</html>