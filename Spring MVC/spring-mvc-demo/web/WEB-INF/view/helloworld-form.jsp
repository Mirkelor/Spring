<!DOCTYPE html>
<html>
    <head>
        <title>Hello World - Input Form</title>
    </head>

    <body>

        <form action="processFormVerThree" method="get">

            <input type="text" name="studentName"
                placeholder="What is your name?"/>

            <input type="submit"/>

        </form>
        <br>
        <img src="${pageContext.request.contextPath}/resources/images/kipachu.jpg"/>
        <br>
        <a href="/spring-mvc-demo">Back to Home Page</a>
    </body>
</html>