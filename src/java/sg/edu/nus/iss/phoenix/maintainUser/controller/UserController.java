/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainUser.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainUser.delegate.MaintainUserDelegate;

/**
 *
 * @author Siva
 */
@WebServlet("/UserController/*")
public class UserController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        processRequest(request, response);

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selection = FCUtilities.stripPath(request.getPathInfo()).toLowerCase();

        MaintainUserDelegate mud = new MaintainUserDelegate();
        User user = new User();
        RequestDispatcher rd = null;
        ArrayList<Role> roleList = new ArrayList<>();
        String result = "";

        switch (selection) {
            case "createuser":
                request.getSession().setAttribute("edituser", user);
                request.getSession().setAttribute("insert", "true");
                rd = getServletContext().getRequestDispatcher("/pages/setupUser.jsp");
                break;
            case "modifyuser":
                user = mud.searchMatching(request.getParameter("id"));
                request.getSession().setAttribute("edituser", user);
                request.getSession().setAttribute("insert", "false");
                rd = getServletContext().getRequestDispatcher("/pages/setupUser.jsp");
                break;

            case "updateuser":
                user.setId(request.getParameter("id"));
                user.setName(request.getParameter("name"));
                user.setPassword(request.getParameter("password"));
                for (String urole : request.getParameterValues("roles")) {
                    Role newRole = new Role();
                    newRole.setRole(urole);
                    roleList.add(newRole);
                }
                user.setRoles(roleList);
                // Create User
                if (request.getParameter("insert").equalsIgnoreCase("true")) {
                    if (mud.createUser(user)) {
                        result = "User created Successfully";
                    } else {
                        result = "Error while creating User, Please refresh and try again !!";
                    }
                } // Update User
                else if (request.getParameter("insert").equalsIgnoreCase("false")) {
                    if (mud.updateUser(user)) {
                        result = "User updated Successfully";
                    } else {
                        result = "Error while updating User, Please refresh and try again !!";
                    }
                }
                rd = getServletContext().getRequestDispatcher("/ReviewSelectUserController/users");
                break;
//This case is invoked from the main controller
//Invoked when delete user opton is selected
//Gets the user id from the request and sets to an user
// Calls the user object to the delagate
// Sets message to be displayed in jsp for the two possibilities
            case "deleteuser":
                user.setId(request.getParameter("id"));
                if (mud.deleteUser(user)) {
                    result = "User deleted Successfully";
                } else {
                    result = "Error !! Either User does not Exist or is assigned to Schedule, "
                            + "Please refresh or unassign and Try again !!";
                }
                mud.deleteUser(user);
                rd = getServletContext().getRequestDispatcher("/ReviewSelectUserController/users");
                break;

            default:
                rd = request.getRequestDispatcher("/ReviewSelectUserController/users");
                break;
        }
        request.setAttribute("msg", result);
        rd.forward(request, response);
    }

}
