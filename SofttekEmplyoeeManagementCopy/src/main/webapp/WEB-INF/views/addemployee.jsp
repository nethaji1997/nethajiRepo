<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body style="background-color: azure">
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>
	
	<div class="container col-md-5">
	<br>
		<div class="card" style="background-color: lightblue;">
			<div class="card-body">
				<form action="insert" method="post">
					<h2>Add New Employee</h2>

					<fieldset class="form-group">
						<label>First Name</label> 
						<input type="text" class="form-control"	name="first_name">
					</fieldset>

					<fieldset class="form-group">
						<label>Last Name</label> 
						<input type="text" class="form-control"	name="last_name">
					</fieldset>

					<fieldset class="form-group">
						<label>Gender</label> 
						<input type="text" class="form-control"	name="gender">
					</fieldset>

					<fieldset class="form-group">
						<label>Address</label> 
						<input type="text" class="form-control"	name="address">
					</fieldset>

					<fieldset class="form-group">
						<label>Date of birth</label> 
						<input type="text" class="form-control" name="birth_date">
					</fieldset>

					<fieldset class="form-group">
						<label>Mobile Number</label> 
						<input type="text"	class="form-control" name="contact_no">
					</fieldset>

					<fieldset class="form-group">
						<label>Employee Type</label> 
						<input type="text"	class="form-control" name="emp_type">
					</fieldset>

					<%-- <c:if test="${employee == null}">
						<input type="hidden" name="id"
							value="<c:out value='${employee.emp_id}' />" />
					</c:if> --%>

					<%-- <fieldset class="form-group">
						<label>Employee Id</label> <input type="text"
							value="<c:out value='${employee.emp_id}' />" class="form-control"
							name="emp_id">
					</fieldset>

					<fieldset class="form-group">
						<label>ISID</label> <input type="text"
							value="<c:out value='${employee.is_id}' />" class="form-control"
							name="is_id">
					</fieldset> --%>

					<%-- value="<c:out value='${employee.first_name}' />"
					value="<c:out value='${employee.last_name}' />"
					value="<c:out value='${employee.gender}' />"
					value="<c:out value='${employee.address}' />".
					value="<c:out value='${employee.birth_date}' />"
					value="<c:out value='${employee.mobile_no}' />"
					value="<c:out value='${employee.emp_type}' />" --%>

					<%-- <fieldset class="form-group">
						<label>User email</label> <input type="text"
							value="<c:out value='${employee.email}' />" class="form-control"
							name="email">
					</fieldset>
 --%>

					<%-- <fieldset class="form-group">
						<label>Joining Date</label> <input type="text"
							value="<c:out value='${employee.joining_date}' />"
							class="form-control" name="joining_date">
					</fieldset> --%>



					<%-- <fieldset class="form-group">
						<label>Employee Status</label> <input type="text"
							value="<c:out value='${employee.emp_status}' />"
							class="form-control" name="emp_status">
					</fieldset> --%>

					<%-- <fieldset class="form-group">
						<label>Experience</label> <input type="text"
							value="<c:out value='${employee.exp_level}' />"
							class="form-control" name="emp_status">
					</fieldset> --%>

					<button type="submit" class="btn btn-success">Save Details</button>
				</form>
			</div>
		</div>
		<br>
	</div>
	
</body>
</html>