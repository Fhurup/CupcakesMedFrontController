/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import data.Cupcake;
import data.DBConnector;
import data.DataException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.DataMapper;
import data.LineItems;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author frederik
 */
public class CommandShop extends Command {

    /**
     * Method takes parameters(int topping, int buttom and int amount) from request and creates
     * a new cupcake.
     * Using the Datamapper method it retrieves the correspondent topping and buttom based on the Integer Value.
     * Creating the amount of Cupcakes based on Integer value 'Amount' 
     * if successful adds it to the session's LineItem ArrayList object.
     * and forwards the request & response to Shop.jsp
     * 
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws DataException 
     */
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        DBConnector connector;
        try {
            connector = new DBConnector();
        } catch (SQLException ex) {
            throw new DataException();
        }
        DataMapper dm = new DataMapper(connector);

        int topping = Integer.parseInt(request.getParameter("firstnumber"));
        int buttom = Integer.parseInt(request.getParameter("secondnumber"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        LineItems LI = (LineItems)request.getSession().getAttribute("Cart");
        LI.AddCupcake(new Cupcake(dm.getAllCupcakeTops().get(topping - 1), dm.getAllCupcakeButtoms().get(buttom - 1),amount));
        
        
        request.getSession().setAttribute("Cart", LI);
        request.getSession().getAttribute("toppings");
        request.getSession().getAttribute("buttoms");
        request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);
    }

    /**
     * Method takes ArrayList<Cupcakes> and calculates total price of cart by
     * iterating through ArrayList and adding up all cupcake.getPrice() and returns Integer totalPrice
     * @param cart
     * @return Integer totalPrice
     */
    
    public static int totalPrice(ArrayList<Cupcake> cart) {
        int totalPrice = 0;
        for (Cupcake cupcake : cart) {
            totalPrice += cupcake.getPrice() * cupcake.getAmount();
        }

        return totalPrice;
    }
}
