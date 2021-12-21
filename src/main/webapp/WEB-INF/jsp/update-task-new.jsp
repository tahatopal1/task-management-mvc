<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .card-height {
            min-height: 305px;
        }
    </style>
</head>

<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<div class="container my-5">

    <c:url var="updateLink" value="/leaders/update-task/place">
        <c:param name="username" value="${session_username}"/>
    </c:url>

    <form:form action="${updateLink}" modelAttribute="task">
        <div>
            <div class="mb-3">
                <label class="form-label">Task label</label>
                <form:input path="title" class="form-control"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Task ID</label>
                <form:input path="id" class="form-control"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Assignee</label>
                <input class="form-control" disabled value="${task.userWsDto.username}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Task Definition</label>
                <p><form:textarea class="form-control" path="definition"/></p>
            </div>
            <div class="mb-3">
                <div class="mb-3">
                    <label class="form-label">Assignees</label>
                    <form:select path="userWsDto.username" class="form-control">
                        <form:options items="${users}"/>
                    </form:select>
                </div>
                <input type="Submit" class="btn btn-success btn-lg float-end"/>
            </div>
        </div>
    </form:form>
</div>
</body>

</html>