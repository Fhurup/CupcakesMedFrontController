<%-- 
    Document   : topMenu
    Created on : Mar 7, 2019, 12:40:37 PM
    Author     : frede
--%>
<link href="../css/menu.css" rel="stylesheet" type="text/css"/>
<%@page import="data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    User user = (User) session.getAttribute("user");
%>

<div id="menu">
    <% if (user != null){
        %>
        <p> Hello <% user.getUsername();%> </p> 
        <%
    }
%>
<a href="jsp/loginOrCreate.jsp">Login or create new user</a>
<br>
<a href="jsp/shop.jsp"> shop </a>

</div>
