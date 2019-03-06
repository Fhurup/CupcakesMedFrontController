/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Commands.Command;
import Pages.ErrorPage;
import Pages.LoginPage;
import Pages.ShopPage;
import data.DBConnector;
import data.DataException;
import data.DataMapper;
import data.Role;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author frede
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DataException {
        try
        {
            Command c = Command.from(request);
            c.execute(request, response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        DBConnector connector;
//        try {
//            connector = new DBConnector();
//        } catch (SQLException ex) {
//            throw new DataException();
//        }
//        DataMapper dm = new DataMapper(connector);
//        
//        String command = request.getParameter("command");
//        if (null == command) {
//            LoginPage.generateLogin(response);
//        }
//        switch (command) {
//            case "login":
//                String email = request.getParameter("email");
//                String pw = request.getParameter("userpass");
//                if (dm.validateUser(email, pw)){
//                session.setAttribute("email", email);
//                session.setAttribute("loggedIn", true);
//                ShopPage.generateShop(response, request);
//                }
//                else{
//                    ErrorPage.generateError(response);
//                }
//                break;
//            case "createUser":
//                String username = request.getParameter("username");
//                String createPw = request.getParameter("userpass");
//                int balance = Integer.parseInt(request.getParameter("balance"));
//                String createEmail = request.getParameter("email");
//                Role role = Role.valueOf(request.getParameter("role"));
//                if (dm.makeUser(username, createPw, balance, createEmail, role)){
//                session.setAttribute("email", createEmail);
//                session.setAttribute("loggedIn", true);               
//                ShopPage.generateShop(response, request);
//                }
//                else {
//                    ErrorPage.generateError(response);
//                }
//                break;
//            case "checkForLogin":
//                Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
//                if (loggedIn == null || !loggedIn) {
//                    LoginPage.generateLogin(response);
//                } else {
//                    ShopPage.generateShop(response, request);
//                }
//            default:
//                LoginPage.generateLogin(response);

        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
