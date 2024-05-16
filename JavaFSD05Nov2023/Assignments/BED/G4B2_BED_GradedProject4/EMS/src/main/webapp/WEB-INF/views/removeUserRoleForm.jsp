<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Remove Role from User</title>
</head>
<body>
    <h2>Remove Role from User</h2>
    <form action="removeUserRole" method="POST">
        <input type="hidden" name="userId" value="${userId}" />
        <select name="roleId">
            <c:forEach items="${userRoles}" var="userRole">
                <option value="${userRole.role.id}">${userRole.role.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Remove Role" />
        <a href="users">Cancel</a>
    </form>
</body>
</html>
