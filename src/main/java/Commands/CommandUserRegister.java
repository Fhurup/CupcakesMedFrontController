/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Pages.ErrorPage;
import Pages.ShopPage;
import data.DBConnector;
import data.DataException;
import data.DataMapper;
import data.Role;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
public class CommandUserRegister extends Command {
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
                String username = request.getParameter("username");
                String createPw = request.getParameter("userpass");
                int balance = Integer.parseInt(request.getParameter("balance"));
                String createEmail = request.getParameter("email");
                Role role = Role.valueOf(request.getParameter("role"));
                

        
        if (dm.makeUser(username, createPw, balance, createEmail, role))
        {
            session.setAttribute("loggedIn", true );
            response.sendRedirect("/jsp/shop.jsp");
        }
        else
        {
            request.setAttribute("errormessage", "User not registered...");
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }
}
