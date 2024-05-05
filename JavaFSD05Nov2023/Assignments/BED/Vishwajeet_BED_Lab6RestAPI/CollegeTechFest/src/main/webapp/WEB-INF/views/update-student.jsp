<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
    <h2>Update Student</h2>
    <form action="/students/update/${student.id}" method="post">
        <input type="hidden" name="id" value="${student.id}">
        
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${student.firstName}"><br><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${student.lastName}"><br><br>
        
        <label for="course">Course:</label>
        <input type="text" id="course" name="course" value="${student.course}"><br><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="country" value="${student.country}"><br><br>
        
        <input type="submit" value="Update Student">
    </form>
</body>
</html>
