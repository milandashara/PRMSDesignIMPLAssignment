/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainUser.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainUser.delegate.MaintainUserDelegate;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);

       }

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
     
        MaintainUserDelegate mu=new MaintainUserDelegate();
       String selection = FCUtilities.stripPath(request.getPathInfo())
				.toLowerCase();
		switch (selection) {

                }
}




}
       