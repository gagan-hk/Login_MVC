<%--
  Created by IntelliJ IDEA.
  User: Gagandeep.Singh
  Date: 1/7/2015
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Hello</title>
<body>
<h1>Enter Login Details</h1>
<form action="LoginController" method="POST">
    <table>
        <tr>
            <td><h3>Username: <input type="text" name="user"></h3></td>
            <td><h3>Password <input type="password" name="pwd" /></h3></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>

<form action="Register.jsp">
    <table>
        <tr>
            <td>
                <input type="submit" value = "Register"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>