<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Insurance Report Generation</h1>
		<div>
			<form:form action="search" modelAttribute="search" method="POST">
				<table>
					<tr>
						<td>Plan Name</td>
						<td><form:select path="planName" class="form-control">
								<form:option value="">-Select-</form:option>
								<form:options items="${name}" />
							</form:select></td>
						<td>Plan Status</td>
						<td><form:select path="planStatus" class="form-control">
								<form:option value="">-Select-</form:option>
								<form:options items="${status}" />
							</form:select></td>
						<td>Gender</td>
						<td><form:select path="gender" class="form-control">
								<form:option value="">-Select-</form:option>
								<form:option value="male">Male</form:option>
								<form:option value="Female">Female</form:option>
							</form:select></td>
					</tr>
					<tr>
						<td>Plan Start Date</td>
						<td><form:input path="plan_start_date" type="date"
								class="form-control" /></td>
						<td>Plan End Date</td>
						<td><form:input path="plan_end_date" type="date"
								class="form-control" /></td>
					</tr>
					<tr>
						<td><a href="/" class="btn btn-secondary">Reset</a></td>
						<td><form:button class="btn btn-primary">Search</form:button>
						</td>
					</tr>
				</table>
			</form:form>
			<hr />
			<h3>Search Results</h3>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>So.No</th>
						<th>Plan Name</th>
						<th>Plan Status</th>
						<th>Gender</th>
						<th>Citizen Name</th>
						<th>Plan Start Date</th>
						<th>Plan End Date</th>
						<th>Benefits Amount</th>
						<th>Denial Reason</th>
						<th>Terminated Date</th>
						<th>Terminated Reason</th>
						<th>Citizen Id</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${plans}" var="plan" varStatus="index">
						<tr>
							<td>${index.count}</td>
							<td>${plan.planName}</td>
							<td>${plan.planStatus}</td>
							<td>${plan.gender}</td>
							<td>${plan.cityzenName}</td>
							<td>${plan.planStartDate}</td>
							<td>${plan.planEndDate}</td>
							<td>${plan.benfitAmount}</td>
							<td>${plan.denailResion}</td>
							<td>${plan.terminateDate}</td>
							<td>${plan.terminationResion}</td>
							<td>${plan.cityzenId}</td>
						</tr>
					</c:forEach>
					<tr>
						<c:if test="${empty plans}">
							<td colspan="12" style="text-align: center">No Record Found</td>
						</c:if>
					</tr>
				</tbody>
			</table>
			<hr />
			Export:
			<button class="btn btn-info">
				<a href="">Excel</a>
			</button>
			<button class="btn btn-info">
				<a href="">Pdf</a>
			</button>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>