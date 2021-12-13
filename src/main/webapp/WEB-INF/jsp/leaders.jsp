<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LEADERS Home Page</title>
</head>
<body>
	<h2>LEADERS Home Page</h2>
	<p>See you in vacation...Secret info</p>
	<hr>
	<c:forEach var="taskWsDto" items="${taskWsDtos}">
		<c:url var="updateLink" value="/leaders/update-task">
			<c:param name="task_id" value="${taskWsDto.id}"/>
		</c:url>
		<p>${taskWsDto.id} / ${taskWsDto.title} /
			<c:if test="${taskWsDto.userWsDto  != null}">
				${taskWsDto.userWsDto.username}
			</c:if>
			<a href="${updateLink}">Update Task</a>
		</p>
	</c:forEach>
	<a href="${pageContext.request.contextPath}/leaders/create-task">Create Task</a>
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>
</html>