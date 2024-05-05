<!DOCTYPE html>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
    <h2>Delete Student</h2>
    <p>Are you sure you want to delete student with ID: ${student.id}?</p>
    <form action="/students/delete/${student.id}" method="post">
        <input type="submit" value="Yes">
        <a href="/students/list">No, Cancel</a>
    </form>
</body>
</html>
