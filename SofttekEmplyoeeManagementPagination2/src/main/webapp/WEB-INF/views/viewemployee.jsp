<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Softtek Employee Management Application</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
label {
	width: 100%;
}

input {
	margin: 8%;
}
/* .input-group.input-group-unstyled input.form-control {
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
}

.input-group-unstyled .input-group-addon {
	border-radius: 4px;
	border: 0px;
	background-color: transparent;
} */
</style>
</head>

<body style="background-color: azure;">

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">
					Employee Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Home</a></li>
			</ul>
		</nav>
	</header>

	<br>
	<div class="card"
		style="background-color: lightblue; margin: auto; width: 60%">
		<div class="card-body">
			<h3 class="text-center">Employee Details</h3>
			<div
				style="width: 100%; margin: auto; display: flex; justify-content: space-around">

				<table>
					<tr>
						<td><label>Employee Id</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.emp_id}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>ISId</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.is_id}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Firstname</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.first_name}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Lastname</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.last_name}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Address</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.address}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Date of Birth</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.birth_date}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Gender</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.gender}"/>
							readonly="readonly"></td>
					</tr>
				</table>

				<table>
					<tr>
						<td><label>Email</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.email_id}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Mobile Number</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.contact_no}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Joining Date</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.joining_date}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Employee Type</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.emp_type}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
						<td><label>Employee Status</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.emp_status}"/>
							readonly="readonly"></td>
					</tr>

					<tr>
					<tr>
						<td><label>Experience</label></td>
						<td><input class="form-control" type="text"
							placeholder=<c:out value="${viewEmployee.exp_level}"/>
							readonly="readonly"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>

