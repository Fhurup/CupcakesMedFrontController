/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import data.Cupcake;
import data.DBConnector;
import data.DataException;
import data.DataMapper;
import data.LineItems;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frederik
 */
public class CommandBuy extends Command {
    
    /**
     * Method takes Session's LineItem ArrayList Object and passes it to the datamappers
     * TakeOrder method which handles the order and adds it to the database
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
        LineItems LI = (LineItems) request.getSession().getAttribute("Cart");
        ArrayList<Cupcake> Cart = LI.getCupcakes();
        
        dm.takeOrder(Cart);
        
        request.getSession().getAttribute("Cart");
        request.getSession().getAttribute("toppings");
        request.getSession().getAttribute("buttoms");
        request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);
    }
    
}
