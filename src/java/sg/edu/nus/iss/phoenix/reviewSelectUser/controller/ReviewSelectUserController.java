/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.reviewSelectUser.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.reviewSelectUser.delegate.UserListDelegate;

/**
 *
 * @author Siva
 */
@WebServlet("/ReviewSelectUserController/*")
public class ReviewSelectUserController extends HttpServlet {

    UserListDelegate ul;

    public ReviewSelectUserController() {
        ul = new UserListDelegate();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selection = FCUtilities.stripPath(request.getPathInfo());
        RequestDispatcher rd;

        switch (selection) {
            case "loadrole":
                List<String> userList = ul.getUserList(request.getParameter("role"));
                JSONArray jsonArray = new JSONArray(userList);
                response.getWriter().println(jsonArray.toString());
                break;
            //This use case is redirected from the main controller when the maintain user use case is selected
//Sets the list if users in the request so that its fetched from the jsp

            case "users":
                ArrayList<User> allUserList = ul.getUserList();
                List<Role> allRoles = ul.getRoleList();
                request.setAttribute("userlist", allUserList);
                request.getSession().setAttribute("allUserRoles", allRoles);
                rd = request.getRequestDispatcher("/pages/crudUser.jsp");
                rd.forward(request, response);
                break;
            default:
                rd = request.getRequestDispatcher("/pages/crudUser.jsp");
                rd.forward(request, response);
                break;
        }
    }

}
