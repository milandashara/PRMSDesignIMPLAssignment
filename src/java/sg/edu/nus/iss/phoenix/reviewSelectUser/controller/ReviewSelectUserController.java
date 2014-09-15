/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectUser.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.reviewSelectUser.delegate.UserListDelegate;

/**
 *
 * @author Siva
 */
@WebServlet("/ReviewSelectUserController")
public class ReviewSelectUserController extends HttpServlet {
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UserListDelegate ul=new UserListDelegate();
        
    ArrayList<User> data = ul.getUserList();
			request.setAttribute("userlist", data);
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/crudUser.jsp");
			rd.forward(request, response);
                        
                        
    }

}
