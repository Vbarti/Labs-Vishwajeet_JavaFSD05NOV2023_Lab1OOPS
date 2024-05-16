<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
    integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
    crossorigin="anonymous">

<title>Employee List</title>

</head>
<body>
<div class="container">

        <h3>Employee List</h3>
        <hr>

        <form action="" class="form-inline">

            <c:url var="addUrl" value="/employees/addEmployeeForm" />

            <!-- Add a button -->
            <a href="${addUrl}" class="btn btn-primary btn-sm mb-3"> Add Employee </a>

            <!-- Add Logout button -->
            <c:url var="logoutUrl" value="/logout" />
            <a href="${logoutUrl}" class="btn btn-primary btn-sm mb-3 mx-auto">
                Logout </a>

        </form>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Actions</th> <!-- Add a new column for actions -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.firstName}</td>
                    <td>${employee.lastName}</td>
                    <td>${employee.email}</td>
                    <td>
                        <a href="viewEmployee?id=${employee.id}">View</a>
                        <a href="editEmployeeForm?id=${employee.id}">Edit</a>
                        <a href="deleteEmployee?id=${employee.id}">Delete</a>
                        <!--<a href="/userRoles/addRole/${employee.id}">Add Roles</a>-->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     <hr>
    <a href="/users/list" class="btn btn-primary">Back to User List</a>
    </div>
</body>
</html>
