<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>

<div class="bg-img d-flex align-items-center justify-content-center" style="background-image: url('img/warehouse2.jpg');
		height: 100vh; background-size: cover;">
		
	<div class="container-md border bg-white p-3">
		<h1>Welcome, <c:out value="${user.getUsername()}"/>!</h1>
		<form action="/inventory" class="d-grid gap-2 m-2">			
			<input class="btn btn-outline-secondary" type="submit" value="Inventory"/>			
		</form>
		<form action="/employees" class="d-grid gap-2 m-2">
			<input class="btn btn-outline-secondary" type="submit" value="Employees Work Schedules"/>
		</form>
		<form action="/logout" class="d-grid gap-2 m-2">
			<input class="btn btn-secondary" type="submit" value="Logout"/>
		</form>
	</div>
</div>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>