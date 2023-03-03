<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body class="bg-dark">
	<div class="container-md border mt-3 bg-white">
		<div class="form-group m-2">
			<h2>Inventory</h2>
			<h6 class="text-danger">Currently logged in: <c:out value="${user.getUsername()}"/></h6>
			<form:form action="/inventory" method="post" modelAttribute="inventory" class="d-grid gap-2 m-2">
				<form:label path="item">Add item:</form:label>
				<form:errors path="item" class="form-control is-invalid"/>
				<form:input path="item" type="text" class="form-control mb-2" placeholder="Enter item name"/>
				<form:label path="qty">Quantity:</form:label>
				<form:errors path="qty" class="form-control is-invalid"/>
				<form:input path="qty" type="number" class="form-control mb-2" placeholder="Enter quantity"/>
				<form:errors path="user"/>
				<form:hidden path="user" value="${user.getId()}"/> <!-- FOR LINKAGE -->
				<input type="submit" value="Add" class="btn btn-outline-secondary"/>
			</form:form>			
		</div>

			<table class="table">
				<thead class="table-secondary">
					<tr>
						<th class="w-50">Item</th>
						<th>Quantity</th>			
						<th>Action</th>	
						<th>Created/Updated by</th>
					</tr>
				</thead>
			</table>
		<div style="height:140px; overflow: scroll;">
			<table class="table table-striped table-bordered table-hover">
				<tbody>
					<c:forEach var="itemList" items="${items}">
						<tr>
							<td class="w-50"><c:out value="${itemList.getItem()}"/></td>
							<td><c:out value="${itemList.getQty()}"/></td>
							<td>
								<a href="/delete/inventory/${itemList.getId()}">delete</a> 
								<a href="/edit/inventory/${itemList.getId()}">edit</a>
							</td>
							<td><c:out value="${itemList.getUser().getUsername()}"/></td>
						</tr>		
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
		<form action="/dashboard" class="d-grid gap-2 m-3">
			<input type="submit" value="Dashboard" class="btn btn-secondary"/>
		</form>

	</div>

<script type="text/javascript" src="<c:url value="/js/bootstrap.bundle.min.js" />"></script>

</body>
</html>