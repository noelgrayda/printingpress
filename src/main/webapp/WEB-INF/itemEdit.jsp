<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body class="bg-dark">
	<div class="container border mt-3 bg-white ">
		<div class="form-group m-2 d-grid gap-2" >
			<h1>Edit Item</h1>
			<form:form action="/edit/inventory/${items.getId()}" method="post" modelAttribute="editItems" class="d-grid gap-2 m-2">
				<form:label path="item">Item Name:</form:label>
				<form:errors path="item" class="form-control is-invalid"/>
				<form:input path="item" type="text" class="form-control mb-2" placeholder="${items.getItem()}"/>
				<form:label path="qty">Quantity:</form:label>
				<form:errors path="qty" class="form-control is-invalid"/>
				<form:input path="qty" type="number" class="form-control mb-2" placeholder="${items.getQty()}"/>
				<form:errors path="user"/>
				<form:hidden path="user" value="${user.getId()}"/> <!-- FOR LINKAGE -->	
				<input type="submit" value="Submit" class="btn btn-outline-secondary"/>
			</form:form>
			<form action="/inventory" class="d-grid gap-2 m-2">
				<input type="submit" value="Back" class="btn btn-secondary"/>
			</form>
		</div>
	</div>
<script type="text/javascript" src="<c:url value="/js/bootstrap.bundle.min.js" />"></script>
</body>
</html>