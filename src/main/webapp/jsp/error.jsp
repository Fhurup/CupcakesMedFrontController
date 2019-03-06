<%-- 
    Document   : error
    Created on : Mar 5, 2019, 11:57:38 AM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String errormessage = "Error occurred...";
            if (request.getAttribute("errormessage") != null) {
                errormessage = (String) request.getAttribute("errormessage");
            }
        %>
        <h2>Error</h2>

        <p>Error message: <%= errormessage%></p>
        <br><br> 
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="landingpage">
            <input type="submit" value="Back to login"/>
        </form>    
    </body>
</html>

