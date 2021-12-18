<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Task Form</title>
</head>
<body>
    <h3>Task Form Page</h3>
    <fmt:parseNumber var = "i" type = "number" value = "${user.id}" />
    <c:url var="createLink" value="/leaders/create-task/place">
        <c:param name="id" value="${i}"/>
    </c:url>

    <form:form action="${createLink}" modelAttribute="taskWsDto">
        <p><form:input path="title" /></p>
        <p><input type="submit"/></p>
    </form:form>
</body>