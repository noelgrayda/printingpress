<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Status</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body class="bg-dark">
	<div class="container-md border bg-light">
		<h1>Edit Status</h1>	
		<table class="table">
			<thead>
				<tr>
					<th>Designation</th>
					<th>Employee Name</th>	
					<th>Work Name</th>	
					<th>Status</th>		
					<th>Action</th>	
				</tr>
			</thead>
			<tbody>
					<tr>
						<td><c:out value="${stat.getDesignation()}"/></td>
						<td><c:out value="${stat.getEmployee()}"/></td>
						<td><c:out value="${stat.getWorkName()}"/></td>
						<td>
							<form:form action="/employees/${stat.getId()}" method="post" modelAttribute="selStat">
									<form:errors path="designation"/>
									<form:hidden path="designation" value="${stat.getDesignation()}"/>
									<form:errors path="employee"/>
									<form:hidden path="employee" value="${stat.getEmployee()}"/>
									<form:errors path="workName"/>
									<form:hidden path="workName" value="${stat.getWorkName()}"/>
									<form:select path="workStatus">
										<form:option path="workStatus" value="done">done</form:option>
										<form:option path="workStatus" value="active">active</form:option>
										<form:option path="workStatus" value="cancelled">cancelled</form:option>
									</form:select>
									<input type="submit" value="Save"/>
									<c:out value="${stat.getWorkStatus()}"/>
									<form:errors path="user"/>
									<form:hidden path="user" value="${user.getId()}"/> <!-- FOR LINKAGE -->	
							</form:form>
						</td>
						<td><a href="/delete/employees/${stat.getId()}">delete</a></td>
					</tr>
			</tbody>
		</table>
	<form action="/employees" class="d-grid gap-2 m-2">
		<input type="submit" value="Back" class="btn btn-secondary"/>
	</form>
	</div>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>