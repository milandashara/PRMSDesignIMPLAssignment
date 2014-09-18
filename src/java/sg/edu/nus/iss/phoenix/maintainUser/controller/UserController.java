/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainUser.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainUser.delegate.MaintainUserDelegate;
import sg.edu.nus.iss.phoenix.reviewSelectUser.controller.ReviewSelectUserController;

/**
 *
 * @author Siva
 */
@WebServlet("/UserController/*")
public class UserController extends HttpServlet {

    MaintainUserDelegate mu = new MaintainUserDelegate();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selection = FCUtilities.stripPath(request.getPathInfo()).toLowerCase();
        User user = new User();
        RequestDispatcher rd;

        switch (selection) {
            case "maintainuser":
                user.setId(request.getParameter("id"));
                user.setName(request.getParameter("name"));
                user.setPassword(request.getParameter("password"));
                user.setId(request.getParameter("id"));
                // Create User
                if (request.getParameter("insert").equalsIgnoreCase("true")) {
                    
                } 
                // Update User
                else if (request.getParameter("insert").equalsIgnoreCase("false")) {

                }
                break;

            case "deleteuser":
                user.setId(request.getParameter("id"));
                mu.deleteUser(user);
                break;

            default:
                break;
        }
        rd = request.getRequestDispatcher("/ReviewSelectUserController");
        rd.forward(request, response);
    }

}
