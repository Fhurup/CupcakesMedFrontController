
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

public abstract class Command
{
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataException;

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
