<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>
    <h2>Student Confirmation</h2>
    <br><br>
    The student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country : ${student.country}
    <br><br>
    Favorite Language : ${student.favoriteLanguage}
    <br><br>
    Operation Systems :
    <ul>
        <c:forEach var="temp" items="${student.favoriteOS}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>
