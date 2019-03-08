<%-- 
    Document   : error
    Created on : Mar 5, 2019, 11:57:38 AM
    Author     : frede
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--include file="topMenu.jsp" --%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

