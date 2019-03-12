
package Commands;

import Commands.CommandUserLogin;
import Commands.CommandUserRegister;
import data.DataException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The Command class is an abstract class used to determine what the system does,
 * depending on a request parameter called "command".
 */
public abstract class Command
{
    /**
     * Execute is an abstract method that all subclasses of command use to
     * handle what happens, depending on the parameter "command".
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws DataException 
     */
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException;

    /**
     * The from method takes a request, and extracts the parameter "command" from the request.
     * It holds a map with all acceptable parameters and their corresponding Commands.
     * It searches the map for a key that matches the parameter gotten from the request.
     * If it is successful it returns the appropriate Command, if the command parameter
     * is unknown it returns the default "CommandUnkown".
     * @param request
     * @return Command 
     */
    public static Command from(HttpServletRequest request)
    {
        Command c;
        
        String origin = request.getParameter("command");
        
//        Map<String, Command> commands = Map.of(
//            "userregister", new CommandUserRegister(),
//            "userlogin", new CommandUserLogin(),
//            "userlogout", new CommandUserLogout(),
//            "userslist", new CommandUsersList(),
//            "userdetails", new CommandUserDetails()
//        );
        
        HashMap<String, Command> commands;


        commands = new HashMap<>();
        commands.put("userlogin", new CommandUserLogin());
        commands.put("userregister", new CommandUserRegister());
        commands.put("landingpage", new CommandLandingPage());
        commands.put("addCupcakeToCart", new CommandShop());
        commands.put("BuyCupcakes", new CommandBuy());




       c = commands.getOrDefault(origin, new CommandUnknown());
        
        return c;
    }
}
