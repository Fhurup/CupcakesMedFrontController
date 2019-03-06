
package Pages;

import data.DataException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ErrorPage {
    public static void generateError(HttpServletResponse response) throws IOException, DataException {

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error during login or user creation, please try again</h1>");
            out.println("<form action=\"FrontController\" method=\"POST\">");
            out.println("<input type=\"hidden\" name=\"command\" value=\"checkForLogin\">");
            out.println("<input type=\"submit\" value=\"Back to login\"/>");
            out.println("</form>");;
            out.println("</body>");
            out.println("</html>");
        }
    }
}
