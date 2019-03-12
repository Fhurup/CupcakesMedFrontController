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
 *This class is used to send the user back to the loginOrCreate page.
 */
public class CommandLandingPage extends Command {
    /**
     * This method forwards the request and response to the loginOrCreate page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws DataException 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException {
        request.getRequestDispatcher("/jsp/loginOrCreate.jsp").forward(request, response);
    }
    
}
