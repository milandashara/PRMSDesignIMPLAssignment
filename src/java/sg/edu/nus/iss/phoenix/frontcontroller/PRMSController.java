/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Milan
 */
//@WebServlet(name = "PRMSController", urlPatterns = {"/"})
public class PRMSController extends HttpServlet {

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
        String pathInfo = request.getPathInfo();
        String action = FCUtilities.stripPath(pathInfo);
        System.out.println("PATH" + pathInfo);
        System.out.println("ACTION" + action);
        String result = chooseUseCase(action);
        RequestDispatcher rd = getServletContext().getRequestDispatcher(result);
        rd.forward(request, response);
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

    private String chooseUseCase(String action) {
        switch (action) {
            case "scheduleScreen":
                return "/ScheduleController/loadAllAnnualSchedule";
            case "scheduleScreen/loadAllWeeklySchedule":
                return "/ScheduleController/loadAllWeeklySchedule";
            case "login":
                return "/LoginController/login";
            case "searchrp":
                return "/ProcessController/search";
            case "setuprp":
                return "/ProcessController/process";
            case "crudrp":
                return "/CRUDRpController";
            case "loadrp":
                return "/ProcessController/load";
            case "deleterp":
                return "/ProcessController/delete";
            case "logout":
                return "/LoginController/logout";
            case "loadUser":
                return "/UserController/loadUser";
            case "deleteUser":
                return "/UserController/deleteUser";
            case "reviewselectspyear":
                return "/ReviewSelectScheduleController/reviewselectscheduledprogram";
            default:
                return "/welcome.jsp";
        }
    }
}
