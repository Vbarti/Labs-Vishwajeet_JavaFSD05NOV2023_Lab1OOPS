<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h2>Add Student</h2>
    <form action="/students/add" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName"><br><br>
        
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName"><br><br>
        
        <label for="course">Course:</label>
        <input type="text" id="course" name="course"><br><br>
        
        <label for="country">Country:</label>
        <input type="text" id="country" name="country"><br><br>
        
        <input type="submit" value="Add Student">
    </form>
</body>
</html>
