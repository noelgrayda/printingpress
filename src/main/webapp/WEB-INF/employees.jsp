<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees Page</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body class="bg-dark">
	<div class="container-md border mt-3 bg-white">
		<div class="form-group m-2">
			<h2>Employees Work Schedules</h2>
			<h6 class="text-danger">Currently logged in: <c:out value="${user.getUsername()}"/></h6>
			<form:form class="d-grid gap-2 m-2" action="/employees" method="post" modelAttribute="employees">
				<form:label path="designation">Designation:</form:label>
				<form:errors path="designation" class="form-control is-invalid"/>
				<form:input path="designation" type="text" class="form-control mb-2" placeholder="Enter designation"/>
				<form:label path="employee">Employee Name:</form:label>
				<form:errors path="employee" class="form-control is-invalid"/>
				<form:input path="employee" type="text" class="form-control mb-2" placeholder="Enter employee name"/>
				<form:label path="workName">Work Name:</form:label>
				<form:errors path="workName" class="form-control is-invalid"/>	
				<form:input path="workName" type="text" class="form-control mb-2" placeholder="Enter name of work"/>
				<form:errors path="workStatus"/>
				<form:hidden path="workStatus" value="active"/> <!-- FOR LINKAGE -->	
				<form:errors path="user"/>
				<form:hidden path="user" value="${user.getId()}"/> <!-- FOR LINKAGE -->	
				<input type="submit" value="Add" class="btn btn-outline-secondary"/>
			</form:form>
		</div>
		<div style="height:140px; overflow:scroll;">
			<table class="table table-striped table-bordered table-hover" >
				<thead class="table-secondary">
					<tr>
						<th>Designation</th>
						<th>Employee Name</th>	
						<th>Work Name</th>	
						<th>Status</th>		
						<th>Created/Updated by</th>
						<th>Action</th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach var="workList" items="${workSched}">
						<tr>
							<td><c:out value="${workList.getDesignation()}"/></td>
							<td><c:out value="${workList.getEmployee()}"/></td>
							<td><c:out value="${workList.getWorkName()}"/></td>
							<td>
								<a href="/employees/${workList.getId()}" class="me-2">update</a>
								<c:out value="${workList.getWorkStatus()}"/>
							</td>
							<td><c:out value="${workList.getUser().getUsername()}"/></td>
							<td><a href="/delete/employees/${workList.getId()}">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
			<form class="d-grid gap-2 m-2" action="/dashboard">
				<input type="submit" value="Dashboard" class="btn btn-secondary"/>
			</form>	
		</div>

</body>
</html>