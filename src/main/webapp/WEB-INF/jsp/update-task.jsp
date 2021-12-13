<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Task Form</title>
</head>
<body>
<h3>Task Form Page</h3>
<c:url var="updateLink" value="/leaders/update-task/place">
    <c:param name="username" value="${session_username}"/>
</c:url>

<form:form action="${updateLink}" modelAttribute="task">
    <p><form:input path="title" /></p>
    <p><form:input path="id" /></p>
    <p><form:input path="userWsDto.username" /></p>
    <p><input type="submit"/></p>
</form:form>
</body>