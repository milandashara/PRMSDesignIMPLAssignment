/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainSchedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;

/**
 *
 * @author Milan
 */
@WebServlet(name = "ScheduleController", urlPatterns = {"/ScheduleController/*"})
public class ScheduleController extends HttpServlet {

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
            throws ServletException, IOException {
        if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("load")) {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/schedule.jsp");;
            rd.forward(request, response);
        }
        else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("deleteSchedule") ) {
			ScheduleDelegate sd = new ScheduleDelegate();
			ProgramSlot pSlot = new ProgramSlot();
                        
//			user.setId(request.getParameter("id"));
//			user.setPassword(request.getParameter("password"));
//			user = ad.validateUserIdPassword(user);
//			RequestDispatcher rd;
//			if (null != user) {
//				request.getSession().setAttribute("user", user);
//				rd = getServletContext().getRequestDispatcher("/pages/home.jsp");;
//			} else
//				rd = getServletContext().getRequestDispatcher("/pages/error.jsp");;
//		    rd.forward(request, response);
		}
     

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
        processRequest(request, response);
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
        processRequest(request, response);
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
