<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login / Register</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body class="bg-img bg-dark">
	<div class="container-md">
		<h1 class="mt-2 text-center text-white">Login/Registration Page</h1>	
		<div class="row">
			<div class="col bg-light border m-2">
				<h3 class="m-2">Register</h3>
				
				<div class="form-group m-2">
					<form:form action="/register" method="post" modelAttribute="newUser">
						<form:label path="username">Username:</form:label>
						<form:errors path="username" class="form-control is-invalid"/>
						<form:input path="username" type="text" class="form-control mb-2" placeholder="Enter username"/>	
						<form:label path="email">Email Address:</form:label>
						<form:errors path="email" class="form-control is-invalid"/>
						<form:input path="email" type="email" class="form-control mb-2" placeholder="Enter email address"/>		
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="form-control is-invalid"/>
						<form:input path="password" type="password" class="form-control mb-2" placeholder="Enter password"/>	
						<form:label path="confirm">Confirm Password:</form:label>
						<form:errors path="confirm" class="form-control is-invalid"/>
						<form:input path="confirm" type="password" class="form-control mb-2" placeholder="Enter password confirmation"/>
						<input type="submit" value="Register" class="btn btn-secondary"/>					
					</form:form>
					
				</div>
				
			</div>
			<div class="col bg-light border m-2">
				<h3 class="m-2">Login</h3>
				
				<div class="form-group m-5">
					<form:form action="/login" method="post" modelAttribute="newLogin">	
						<form:label path="email">Email Address:</form:label>
						<form:errors path="email" class="form-control is-invalid"/>
						<form:input path="email" type="email" class="form-control mb-2" placeholder="Enter email address"/>		
						<form:label path="password">Password:</form:label>
						<form:errors path="password" class="form-control is-invalid"/>
						<form:input path="password" type="password" class="form-control mb-2" placeholder="Enter password"/>	
						<input type="submit" value="Login" class="btn btn-secondary"/>	
								
					</form:form>
				
				</div>
			</div>
		</div>
			<form action="/" class="d-grid gap-2 m-2">
				<input type="submit" value="Home" class="btn btn-secondary"/>
			</form>
	</div>

<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>

</body>
</html>