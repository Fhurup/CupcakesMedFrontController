/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Pages.ErrorPage;
import Pages.ShopPage;
import data.CupcakeButtom;
import data.CupcakeTop;
import data.DBConnector;
import data.DataException;
import data.DataMapper;
import data.LineItems;
import data.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandUserLogin extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        HttpSession session = request.getSession();

        DBConnector connector;
        try {
            connector = new DBConnector();
        } catch (SQLException ex) {
            throw new DataException();
        }
        DataMapper dm = new DataMapper(connector);
        String email = request.getParameter("email");
        String pw = request.getParameter("userpass");
        User user = dm.getUser(email);
        if (dm.validateUser(email, pw)) {
            session.setAttribute("user", user);
            //session.setAttribute("email", email);
            session.setAttribute("loggedIn", true);
            List<CupcakeTop> Toppings = new ArrayList<>(dm.getAllCupcakeTops());
            List<CupcakeButtom> Buttoms = new ArrayList<>(dm.getAllCupcakeButtoms());
            request.setAttribute("toppings", Toppings);
            request.setAttribute("buttoms", Buttoms);
            session.setAttribute("toppings", Toppings);
            session.setAttribute("buttoms", Buttoms);
            LineItems LI = new LineItems();
            session.setAttribute("Cart", LI);
            request.getRequestDispatcher("/jsp/shop.jsp").forward(request, response);
        } else {
            request.setAttribute("errormessage", "Wrong username og password...");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }

}
