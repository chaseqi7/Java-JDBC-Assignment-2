<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/A1.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Individual Geographic Details</title>
</head>
<c:set var="count" value="0" scope="page" />
<body>
	<jsp:useBean id="geoDataBean" class="prog3060.jwong.GeoDataBean" />
	<h1>
		Geographic Area ID:
		<%=request.getParameter("geographicAreaID")%></h1>
	<c:forEach items="${geoDataBean.numberOfHouseholds}" var="households">
		<c:choose>
			<c:when
				test="${households.geographicArea.geographicAreaId == param.geographicAreaID}">
				<c:set var="count" value="${count +households.numberReported}"
					scope="page" />
			</c:when>
		</c:choose>
	</c:forEach>
	<c:forEach items="${geoDataBean.geographicList}" var="item">
		<c:choose>
			<c:when test="${item.geographicAreaId == param.geographicAreaID}">
				<div class="container">
					<div class="sm-col-6">
						<h3>Details:</h3>
						<table class="table table-bordered">
							<tr>
								<td>Geographic Area ID:</td>
								<td><c:out value="${item.geographicAreaId}" /></td>
							</tr>
							<tr>
								<td>Code:</td>
								<td><c:out value="${item.code}" /></td>
							</tr>
							<tr>
								<td>Level:</td>
								<td><c:out value="${item.level}" /></td>
							</tr>
							<tr>
								<td>Name:</td>
								<td><c:out value="${item.name}" /></td>
							</tr>
							<tr>
								<td>Alternative Code:</td>
								<td><c:out value="${item.alternativeCode}" /></td>
							</tr>
							<c:if test="${item.level ==0||item.level ==1}">
								<tr>
									<td>Number of Households</td>
									<td><c:out value="${count}" /></td>
								</tr>
							</c:if>
							<c:if test="${item.level ==0}">
								<c:forEach items="${geoDataBean.geographicList}" var="location">
									<c:if test="${location.level == 1}">
										<tr>
											<td><c:out value="${location.name}" /></td>
											<td><c:out value="${location.alternativeCode}" /></td>
										</tr>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${item.level ==1}">
								<c:forEach items="${geoDataBean.geographicList}" var="location">
									<c:if
										test="${location.level == 2 && fn:substring(location.alternativeCode, 0, 2)==item.alternativeCode}">
										<tr>
											<td><c:out value="${location.name}" /></td>
											<td><c:out value="${location.alternativeCode}" /></td>
										</tr>
									</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${item.level ==2}">
								<c:forEach items="${geoDataBean.geographicList}" var="location">
									<c:if
										test="${location.level == 3 && fn:substring(location.alternativeCode, 0, 5)==item.alternativeCode}">
										<tr>
											<td><c:out value="${location.name}" /></td>
											<td><c:out value="${location.alternativeCode}" /></td>
										</tr>
									</c:if>
								</c:forEach>
							</c:if>
						</table>
					</div>
				</div>
			</c:when>
		</c:choose>
	</c:forEach>
	<c:forEach var="i" begin="2011" end="2016" step="5">
		<c:forEach items="${geoDataBean.popData}" var="pop">
			<c:choose>
				<c:when
					test="${pop.geographicArea.geographicAreaId == param.geographicAreaID && pop.censusYear.censusYear == i}">
					<div class="container">
						<div class="sm-col-6">
							<h3>Census Year ${i}:</h3>
							<table class="table table-bordered">
								<tr>
									<td>Combined:</td>
									<td><c:out value="${pop.combined}" /></td>
								</tr>
								<tr>
									<td>Male:</td>
									<td><c:out value="${pop.male}" /></td>
								</tr>
								<tr>
									<td>Female:</td>
									<td><c:out value="${pop.female}" /></td>
								</tr>
							</table>
						</div>
					</div>
				</c:when>
			</c:choose>
		</c:forEach>
	</c:forEach>
</body>

</html>