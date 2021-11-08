<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My first servlet</title>
</head>
    <body>
        <h1><%= "This is a message from index.jsp" %></h1><br>
                <a href="hello-servlet">Link to localhost:8081/hello-servlet</a><br>
                <a href="my_servlet">Link to localhost:8081/my_servlet</a><br>
                <a href="small_trying">Link to localhost:8081/small_trying</a><br>
                <a href="small_trying2">Link to localhost:8081/small_trying2</a><br>
                <a href="small_trying3">Link to localhost:8081/small_trying3</a><br>
                <a href="small_trying4">Link to localhost:8081/small_trying4 without parameters goes to 404</a><br>
                <a href="small_trying4?id=456">Link to localhost:8081/small_trying4 with parameters</a><br>
                <a href="/first">Link to localhost:8081/first</a><br>
                <a href="/second">Link to localhost:8081/second</a><br>
                <a href="/download">Link to localhost:8081/download</a><br><br>


        <form action="small_trying2" method="POST">
            <label>
                Name of a person:
                <br>
                <input name="userName">
            </label>
            <br>
            <label>
                Age of a person:
                <br>
                <input name="userAge">
            </label>
            <br><br>
            Gender :
            <br>
            <label>
                <input type="radio" name="gender" value="male" checked>
                Male
            </label>
            <br>
            <label>
                <input type="radio" name="gender" value="female">
                Female
            </label>

            <br><br>
            <label>
                Country:
                <select name="country">
                <option>Canada</option>
                <option>USA</option>
                <option>Spain</option>
                <option>France</option>
                <option>Germany</option>
                <option>Belgium</option>
                <option>Hungary</option>
            </select>
            </label>

            <br><br>
            Courses:<br>
            <label>
                <input type="checkbox" name="courses" value="Java Core" checked>
                Java Core
            </label><br>
            <label>
                <input type="checkbox" name="courses" value="JavaSE">
                Java SE
            </label><br>
            <label>
                <input type="checkbox" name="courses" value="JavaFX" checked>
                Java FX
            </label><br>
            <label>
                <input type="checkbox" name="courses" value="JavaEE">
                Java EE
            </label><br>
            <br>
            <input type="submit" value="Submit">
            <input type="reset" value="Erase All">
        </form>
    </body>
</html>
