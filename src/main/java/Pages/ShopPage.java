
package Pages;

import data.DBConnector;
import data.DataException;
import data.DataMapper;
import data.LineItems;
import data.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShopPage {
    public static void generateShop(HttpServletResponse response, HttpServletRequest request) throws IOException, DataException
    {
        
        DBConnector connector;
        try {
            connector = new DBConnector();
        } catch (SQLException ex) {
            throw new DataException();
        }
        DataMapper dm = new DataMapper(connector);
        LineItems currentOrder = new LineItems();
        
        try (PrintWriter out = response.getWriter()) {
            String n = request.getParameter("email");
            User loggedIn = dm.getUser(n);
            out.print("Welcome " + n + " Your current balance is: " + loggedIn.getBalance());
            out.print("<br/>");
            out.print("<br/>");
            out.print("<br/>");

            for (int i = 0; i < dm.getAllCupcakeTops().size(); i++) {
                try {
                    out.println(dm.getAllCupcakeTops().get(i));
                } catch (Exception ex) {
                    System.out.println("FEJL 1");
                }
                
            }

            out.print("<br/>");
            for (int j = 0; j < dm.getAllCupcakeButtoms().size(); j++) {
                try {
                    out.println(dm.getAllCupcakeButtoms().get(j));
                } catch (Exception ex) {
                    System.out.println("FEJL 2");
                }
                

            }
            out.print("<br/>");
            out.print("<form method=\"GET\">\n"
                    + "            Vælg Topping:<br>\n"
                    + "            <input type=\"text\" name=\"firstnumber\" value=\"1\"><br>\n"
                    + "            Vælg Bottom:<br>\n"
                    + "            <input type=\"text\" name=\"secondnumber\" value=\"1\"><br><br>\n"
                    + "            <input type=\"hidden\" name=\"action\" value=\"addCupcakeToCart\">"
                    + "            <input type=\"submit\" value=\"Add\">\n"
                    + "        </form>");
        }
        
    }
}
