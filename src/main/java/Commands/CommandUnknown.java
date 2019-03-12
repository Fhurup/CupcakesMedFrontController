/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import data.DataException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *This class is used if the "command" parameter is unknown to the system.
 */
public class CommandUnknown extends Command {
    /**
     * This method sets an attribute called "errormessage" and forwards the request and response to the error page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws DataException 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        request.setAttribute("errormessage", "Unknown command...");
        request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }

}
