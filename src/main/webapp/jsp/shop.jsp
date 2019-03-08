<%-- 
    Document   : shop
    Created on : Mar 5, 2019, 11:57:54 AM
    Author     : frede
--%>
<script src="../images/maxcdn.bootstrapcdn.com_bootstrap_3.4.0_js_bootstrap.min.js" type="text/javascript"></script>
<%@page import="data.Cupcake"%>
<%@page import="data.CupcakeButtom"%>
<%@page import="data.CupcakeTop"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Commands.CommandShop"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
    </head>
    <body>
        <br/>
        <form method="GET">
            Vælg Topping: <input type="text" name="firstnumber" value="1">
            Vælg Bottom: <input type="text" name="secondnumber" value="1">
            Vælg Antal: <input type="text" name="amount" value="1">
            <input type="hidden" name="command" value="addCupcakeToCart">
            <input type="submit" value="Add">
        </form>
        
        <table class="table table-striped">
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
            <table class="table table-striped">
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
            <table class="table table-striped">
            <thead><tr><th>Cupcake</th><th>Price</th></thead> 
            <tbody>
                        <% List<Cupcake> cupcakes = (ArrayList<Cupcake>) session.getAttribute("Cart");
                            for (Cupcake cupcake : cupcakes) {
                        %>  
                <tr>
                    <td><%= cupcake.getName()%></td><td><%=cupcake.getPrice()%></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    <td>Total Price: <%= CommandShop.totalPrice((ArrayList)cupcakes)%></td>
                </tr>
            </tbody>
            </table>
            
            
    </body>
</html>
