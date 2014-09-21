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
import sg.edu.nus.iss.phoenix.reviewSelectUser.controller.ReviewSelectUserController;

/**
 *
 * @author Siva
 */
@WebServlet("/UserController/*")
public class UserController extends HttpServlet {

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

        MaintainUserDelegate mud = new MaintainUserDelegate();
        User user = new User();
        RequestDispatcher rd = null;
        ArrayList<Role> roleList = new ArrayList<>();

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
                for (String urole : request.getParameter("roles").split(":")) {
                    Role newRole = new Role();
                    newRole.setRole(urole);
                    roleList.add(newRole);
                }
                user.setRoles(roleList);
                // Create User
                if (request.getParameter("insert").equalsIgnoreCase("true")) {
                    mud.createUser(user);
                } // Update User
                else if (request.getParameter("insert").equalsIgnoreCase("false")) {
                    mud.updateUser(user);
                }
                rd = getServletContext().getRequestDispatcher("/ReviewSelectUserController/users");
                break;

            case "deleteuser":
                user.setId(request.getParameter("id"));
                mud.deleteUser(user);
                rd = getServletContext().getRequestDispatcher("/ReviewSelectUserController/users");
                break;

            default:
                rd = request.getRequestDispatcher("/ReviewSelectUserController/users");
                break;
        }
//        rd = request.getRequestDispatcher("/ReviewSelectUserController");
        rd.forward(request, response);
    }

}
