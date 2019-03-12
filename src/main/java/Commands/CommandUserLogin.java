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
 * This class is used if the user tries to log in.
 */
public class CommandUserLogin extends Command {

    /**
     * This method takes the parameters email and password and uses the
     * validateUser method from the DataMapper check if the information matches
     * an existing user. If successful it saves the user in the session and sets
     * a session attribute called "loggedIn" to true.
     * It then prepares information needed for the shop page, and forwards the
     * request and response to the shop page.
     * If unsuccessful it sets the attribute "errormessage" and forwards
     * request and response to the error page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws DataException
     */
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
