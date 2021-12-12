<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Task Form</title>
</head>
<body>
    <h3>Task Form Page</h3>
    <form:form action="/leaders/create-task/place?username=${session_username}" modelAttribute="taskWsDto">
        <p><form:input path="title" /></p>
        <p><input type="submit"/></p>
    </form:form>
</body>