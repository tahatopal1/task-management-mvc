<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documental</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .card-height {
            min-height: 305px;
        }
    </style>
</head>

<body>

<div class="container mt-5" style="height: 750px;">
    <h1 class="display-6 text-center mt-2">Tasks</h1>
    <div class="row mt-5" style="height: 500px;">
        <div class="col-12 mt-5">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Task ID</th>
                    <th scope="col">Task Label</th>
                    <th scope="col">Assignee</th>
                    <th scope="col">Operations</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="taskWsDto" items="${taskWsDtos}">
                    <c:url var="updateLink" value="/leaders/update-task">
                        <c:param name="task_id" value="${taskWsDto.id}"/>
                    </c:url>
                    <c:url var="deleteLink" value="/leaders/delete-task">
                        <c:param name="task_id" value="${taskWsDto.id}"/>
                    </c:url>
                    <tr>
                        <th scope="row">${taskWsDto.id}</th>
                        <td>${taskWsDto.title}</td>
                        <td>
                            <c:if test="${taskWsDto.userWsDto  != null}">
                                ${taskWsDto.userWsDto.username}
                            </c:if>
                        </td>
                        <td>
                            <a href="${updateLink}" class="btn btn-warning btn-sm">Update</a>
                            <a href="${deleteLink}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="container">
    <div class="float-end">
        <a href="${pageContext.request.contextPath}/leaders/create-task" class="btn btn-success">Create Task</a>
        <a href="${pageContext.request.contextPath}/" class="btn btn-warning">Back to Home</a>
    </div>
</div>
</body>

</html>