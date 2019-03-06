package Pages;

import data.DBConnector;
import data.DataException;
import data.DataMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

public class LoginPage {

    public static void generateLogin(HttpServletResponse response) throws IOException, DataException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login</h1>");
            out.println("<form action=\"FrontController\" method=\"POST\">");
            //out.println("<form method=\"POST\">");
            out.println("Email:<input type=\"text\" name=\"email\"/><br/><br/>");
            out.println("Password:<input type=\"password\" name=\"userpass\"/><br/><br/>");
            out.println("<input type=\"hidden\" name=\"command\" value=\"login\">");
            out.println("<input type=\"submit\" value=\"login\"/>");
            out.println("</form>");
            out.println("<br/><br/>");
            out.println("<h1> Create New User</h1>");
            //out.println("<form method=\"GET\">\n");
            out.println("<form action=\"FrontController\" method=\"POST\">");
            out.println("Username:<input type=\"text\" name=\"username\"/><br/><br/>");
            out.println("Password:<input type=\"password\" name=\"userpass\"/><br/><br/>");
            out.println("Balance:<input type=\"number\" name=\"balance\"/><br/><br/>");
            out.println("Email:<input type=\"text\" name=\"email\"/><br/><br/>");
            out.println("Admin:A/User:U <input type=\"text\" name=\"role\"/><br/><br/>");
            out.println("<input type=\"hidden\" name=\"command\" value=\"createUser\">");
            out.println("<input type=\"submit\" value=\"create\"/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
            //out.println("<p><a href=\"/FrontControllerTest/FrontController?action=login\">Log in</a></p>");
            //action=\"FrontController?action=createUser\"

