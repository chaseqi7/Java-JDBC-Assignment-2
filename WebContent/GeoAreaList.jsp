<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/A1.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Assignment 3 - Geographic Area</title>
</head>
<body>
	<jsp:useBean id="geoDataBean" class="prog3060.jwong.GeoDataBean" />
	<%-- Begin Geo --%>
	<div class="page-container">
		<a name="Geo"></a>
		<h1>Geographic Area Classification List</h1>
		<nav class="navbar navbar fixed-top">
			<a class="navbar-brand" href="#Age">Age Group List Page</a> <a
				class="navbar-brand" href="#Income">Median Total Household Page</a>
		</nav>
		<div class="row">
			<div class="col-sm-12">
				<div class="container table-container table-bordered">
					<c:set var="geographicAreaList" scope="session" value="${myList}" />
					<c:forEach var="i" begin="0" end="3" step="1">
						<table class="table">
							<tr>
								<th>Level ${i}</th>
							</tr>
							<c:forEach items="${geoDataBean.geographicList}" var="item">
								<tr>
									<c:choose>
										<c:when test="${item.level == i}">
											<td><a
												href="./GeographicDetails.jsp?geographicAreaID=${item.geographicAreaId}" />
												<c:out value="${item.name}" /></td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 50px;">
			<a name="Age"></a>
			<div class="col-sm-12">
				<h1>Age Group List:</h1>
				<div class="container table-container table-bordered">
					<h2>Year 2011:</h2>
					<table class="table">
						<tr>
							<th>Age Group Description</th>
							<th>Male Population</th>
							<th>Female Population</th>
						</tr>
						<c:forEach items="${geoDataBean.ageGroup}" var="item">
							<c:choose>

								<c:when test="${item.censusYear.censusYear == 2011}">
									<tr>
										<td>${item.ageGroup.description}</td>
										<td>${item.male}</td>
										<td>${item.female}</td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</table>
				</div>
				<div class="container table-container table-bordered"
					style="margin-top: 75px;">
					<h2>Year 2016:</h2>
					<table class="table">
						<tr>
							<th>Age Group Description</th>
							<th>Male Population</th>
							<th>Female Population</th>
						</tr>
						<c:forEach items="${geoDataBean.ageGroup}" var="item">
							<c:choose>

								<c:when test="${item.censusYear.censusYear == 2016}">
									<tr>
										<td>${item.ageGroup.description}</td>
										<td>${item.male}</td>
										<td>${item.female}</td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 50px;">
			<a name="Income"></a>
			<div class="col-sm-12">
				<h1>Median Total Household Income List:</h1>
				<div class="container table-container table-bordered">
					<table class="table">
						<tr>
							<th>Geographic Area</th>
							<th>Median Total Household Income</th>
						</tr>
						<c:forEach items="${geoDataBean.householdIncome}" var="item">
							<tr>
								<td>${item.geographicArea.name}</td>
								<td>${item.numberReported}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%-- End Geo --%>
</body>
</html>