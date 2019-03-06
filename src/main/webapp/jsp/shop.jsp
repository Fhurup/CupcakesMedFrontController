<%-- 
    Document   : shop
    Created on : Mar 5, 2019, 11:57:54 AM
    Author     : frede
--%>

<%@page import="data.Cupcake"%>
<%@page import="data.CupcakeButtom"%>
<%@page import="data.CupcakeTop"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br/>
        <form method="GET">
            Vælg Topping: <input type="text" name="firstnumber" value="1">
            Vælg Bottom: <input type="text" name="secondnumber" value="1"><br><br>
            <input type="hidden" name="command" value="addCupcakeToCart">
            <input type="submit" value="Add">
        </form>
        <table>
            <thead><tr><th>Topping</th><th>Price</th></tr></thead> <tbody>
                        <% List<CupcakeTop> Toppings = (ArrayList<CupcakeTop>) session.getAttribute("toppings");
                            for (CupcakeTop CupcakeTop : Toppings) {
                        %>
                <tr>
                    <td><%= CupcakeTop.getName()%></td><td><%= CupcakeTop.getPrice() + "kr"%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
            </table>
            <table>
            <thead><tr><th>Buttom</th><th>Price</th></tr></thead> <tbody>
                        <% List<CupcakeButtom> buttoms = (ArrayList<CupcakeButtom>) session.getAttribute("buttoms");
                            for (CupcakeButtom CupcakeButtom : buttoms) {
                        %>
                <tr>
                    <td><%= CupcakeButtom.getName()%></td><td><%= CupcakeButtom.getPrice() + "kr"%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
            </table>
            <table>
            <thead><tr><th>Cupcake</th><th>Price</th></tr></thead> 
            <tbody>
                        <% List<Cupcake> cupcakes = (ArrayList<Cupcake>) session.getAttribute("Cart");
                            for (Cupcake cupcake : cupcakes) {
                        %>  
                <tr>
                    <td><%= cupcake.getName()%></td><%=cupcake.getPrice()%>
                </tr>
                <%
                    }
                %>
            </tbody>
            </table>
            
            
    </body>
</html>
