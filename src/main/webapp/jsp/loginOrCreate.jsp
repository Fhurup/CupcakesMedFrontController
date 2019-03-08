<%-- 
    Document   : loginOrCreate
    Created on : Mar 5, 2019, 10:43:24 AM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--include file="topMenu.jsp" --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .container {
                width: 500px;
                clear: both;
            }

            .container input {
                width: 100%;
                clear: both;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <form action="FrontController" method="POST">
                Email:<input type="text" name="email"/><br/><br/>
                Password:<input type="password" name="userpass"/><br/><br/>
                <input type="hidden" name="command" value="userlogin">
                <input type="submit" value="login"/>
            </form>

            <br/><br/>
            <h1> Create New User</h1>
            <form action="FrontController" method="POST">
                Username:<input type="text" name="username"/><br/><br/>
                Password:<input type="password" name="userpass"/><br/><br/>
                Balance:<input type="number" name="balance"/><br/><br/>
                Email:<input type="text" name="email"/><br/><br/>
                Admin:A/User:U <input type="text" name="role"/><br/><br/>
                <input type="hidden" name="command" value="userregister">
                <input type="submit" value="register"/>
            </form>
        </div>
    </body>
</html>
