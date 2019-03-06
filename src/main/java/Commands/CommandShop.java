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
import java.util.List;

/**
 *
 * @author frederik
 */
public class CommandShop extends Command {

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
        Cupcake cc = new Cupcake(dm.getAllCupcakeTops().get(topping -1), dm.getAllCupcakeButtoms().get(buttom - 1));
        LineItems LI = new LineItems();
        LI.AddCupcake(cc);
        List Cart = LI.getCupcakes();
        request.getSession().setAttribute("Cart", Cart);
        request.getSession().getAttribute("toppings");
        request.getSession().getAttribute("buttoms");
        request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);
    }
}
