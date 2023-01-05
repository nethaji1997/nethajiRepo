<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Softtek Employee Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
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

	<div class="ro">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>

			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success"><i
					class="fa-solid fa-user"></i> Add New Employee</a> <a
					href="<%=request.getContextPath()%>/p_to_c" class="btn btn-success">
					Prob 2 Conf</a> <a href="<%=request.getContextPath()%>/stats"
					class="btn btn-success">Statistics</a>
				<div style="float: right; width: 200px; position: relative;"
					class="input-group input-group-unstyled">
					<input type="text" class="form-control" /> <span
						class="input-group-addon"> <i class="fa fa-search"
						style="position: absolute; right: 4%; bottom: 25%;"></i>
					</span>
				</div>
				&nbsp; <a style="float: right; color: white; margin-right: 10px;"
					href="<%=request.getContextPath()%>/new" class="btn btn-dark">
					Search Employee</a>&nbsp; <br> <br>
			</div>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Employee Id</th>
						<th>Name</th>
						<!--<th>Last Name</th-->
						<th>Email</th>
						<th>Mobile Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${listEmployees}">

						<tr>
							<td><c:out value="${emp.emp_id}" /></td>
							<td><c:out value="${emp.first_name} ${emp.last_name}" /></td>
							<td><c:out value="${emp.contact_no}" /></td>
							<td><c:out value="${emp.email_id}" /></td>
							<td><a class="btn btn-primary btn-sm"
								href="edit?emp_id=<c:out value='${emp.emp_id}' />"> <i
									class="fas fa-edit"></i> Edit
							</a> &nbsp; <a class="btn btn-danger btn-sm"
								href="delete?emp_id=<c:out value='${emp.emp_id}' />"><i
									class="fa fa-trash" aria-hidden="true"></i> Delete</a> &nbsp; <a
								class="btn btn-warning btn-sm"
								href="view?emp_id=<c:out value='${emp.emp_id}' />"><i
									class="fa-solid fa-eye"></i> View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav aria-label="Navigation for countries">
				<ul class="pagination">
					<c:if test="${currentPage gt 1}">
						<li class="page-item"><a class="page-link"
							href="list?currentPage=${currentPage-1}">Previous</a></li>
					</c:if>

					<c:forEach begin="1" end="${noOfPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<li class="page-item active"><a class="page-link"> ${i}
										<span class="sr-only">(current)</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="list?currentPage=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${currentPage lt noOfPages}">
						<li class="page-item"><a class="page-link"
							href="list?currentPage=${currentPage+1}">Next</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>


</body>
</html>

