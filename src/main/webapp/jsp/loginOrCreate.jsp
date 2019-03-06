<%-- 
    Document   : loginOrCreate
    Created on : Mar 5, 2019, 10:43:24 AM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #loginform {
                text-align: center;
                color: green;
                border-style: solid;
                border-width: 5px;
                border-color: blue;
            }
        </style>
    </head>
    <body>
        <div id="loginform">
        <h1>Login</h1>
        <form action="FrontController" method="POST">
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="userpass"/><br/><br/>
            <input type="hidden" name="command" value="userlogin">
            <input type="submit" value="login"/>
        </form>
        </div>
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
    </body>
</html>
