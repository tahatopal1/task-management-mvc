<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
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
    <h1 class="display-6 text-center mt-2">Welcome to home page</h1>
    <div class="row mt-5" style="height: 500px;">
        <div class="col-xs-12 col-md-4 mt-5">
            <div class="card border-primary mb-3 card-height">
                <div class="card-header">User Info</div>
                <div class="card-body text-primary">
                    <h5 class="card-title mb-3">User: ${user.username}</h5>
                    <p class="card-text mb-2">User ID: ${user.id}</p>
                    <p class="card-text mb-2">Name: ${user.firstName}</p>
                    <p class="card-text mb-2">Surname: ${user.lastName}</p>
                    <p class="card-text mb-2">Email: ${user.email}</p>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-4 mt-5">
            <div class="card border-secondary mb-3 card-height">
                <div class="card-header">Roles</div>
                <div class="card-body text-secondary">
                    <h5 class="card-title">You can show the roles below</h5>
                    <p class="card-text">Links will appear according to your roles.</p>
                    <security:authorize access="hasRole('MANAGER')">
                        <span class="badge bg-primary">MANAGER</span>
                    </security:authorize>
                    <security:authorize access="hasRole('ADMIN')">
                        <span class="badge bg-success">ADMIN</span>
                    </security:authorize>
                    <security:authorize access="hasRole('EMPLOYEE')">
                        <span class="badge bg-secondary">EMPLOYEE</span>
                    </security:authorize>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-4 mt-5">
            <div class="card border-success mb-3 card-height">
                <div class="card-header">Links</div>
                <div class="card-body text-success">
                    <h5 class="card-title">Links are below</h5>
                    <p class="card-text mb-5">You can navigate to the links by pressing buttons.</p>
                    <div class="d-grid gap-2 col-9 mx-auto">
                        <security:authorize access="hasRole('MANAGER')">
                            <a href="${pageContext.request.contextPath}/leaders" class="btn btn-outline-primary" type="button">Go To Admin Panel &#8594;</a>
                        </security:authorize>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>