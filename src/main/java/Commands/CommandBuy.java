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
    
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        DBConnector connector;
        try {
            connector = new DBConnector();
        } catch (SQLException ex) {
            throw new DataException();
        }
        DataMapper dm = new DataMapper(connector);
        
        
        dm.takeOrder((ArrayList<Cupcake>) request.getSession().getAttribute("Cart"), CommandShop.totalPrice((ArrayList) request.getSession().getAttribute("Cart")));
        
        request.getSession().getAttribute("Cart");
        request.getSession().getAttribute("toppings");
        request.getSession().getAttribute("buttoms");
        request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);
    }
    
}
