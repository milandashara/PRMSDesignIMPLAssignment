/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.delegate.reviewPresenterProducerDelegate;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.entity.PresenterProducer;

/**
 *
 * @author sakthi
 */
@WebServlet(name = "reviewSelectPresenterProducerController",urlPatterns = "/reviewSelectPresenterProducerController/*")
public class ReviewSelectPresenterProducerController extends HttpServlet{
    
    /**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewSelectPresenterProducerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            try {
                // TODO Auto-generated method stub
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ReviewSelectPresenterProducerController.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            try {
                // TODO Auto-generated method stub
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ReviewSelectPresenterProducerController.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, SQLException {
                        String role = request.getParameter("role");
                        String id = request.getParameter("id");
			reviewPresenterProducerDelegate ppdel = new reviewPresenterProducerDelegate();
			ArrayList<PresenterProducer> data = ppdel.getAllPresenterProducer(role);
			request.setAttribute("PresenterProducer", data);
                        request.setAttribute("role", role);
                        request.setAttribute("id", id);
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/PresenterProducer.jsp");
			rd.forward(request, response);	
		}
    
}
