/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.edu.nus.iss.phoenix.frontcontroller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainSchedule.controller.ScheduleController;
import sg.edu.nus.iss.phoenix.maintainSchedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.delegate.ReviewSelectSheduledProgramDelegate;

/**
 *
 * @author mani
 */
@WebServlet(name = "ReviewSelectSheduledProgramController", urlPatterns = {"/ReviewSelectSheduledProgramController/*"})
public class ReviewSelectSheduledProgramController extends HttpServlet {
    
     ReviewSelectSheduledProgramDelegate reviewSelectSheduledProgramDelegate;
    public ReviewSelectSheduledProgramController() {
      reviewSelectSheduledProgramDelegate  = new ReviewSelectSheduledProgramDelegate();
    }

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
         if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("loadAllAnnualSchedule")) {
            
            List<AnnualSchedule> annualScheduleList = reviewSelectSheduledProgramDelegate.getAllAnnualScheduleList();
            request.setAttribute("annualScheduleList", annualScheduleList);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/schedule.jsp");;
            rd.forward(request, response);
        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("loadAllWeeklySchedule")) {
          
            Integer year = Integer.parseInt(request.getParameter("year").toString());
            List<WeeklySchedule> weeklyScheduleList = reviewSelectSheduledProgramDelegate.getAllWeeklySchedule(year);
            JSONArray jsonArray = new JSONArray();
            for (WeeklySchedule weeklySchedule : weeklyScheduleList) {
                JSONObject jsonObject = new JSONObject();
                try {
                    
                    jsonObject.put("startDate", new SimpleDateFormat("dd-MM-yyyy").format(weeklySchedule.getStartDate()));
                } catch (JSONException ex) {
                    Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                }
                jsonArray.put(jsonObject);
            }
            JSONObject jo=new JSONObject();
            try {
                jo.put("weeklySchedules", jsonArray);
            } catch (JSONException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.getWriter().println(jsonArray.toString());
        }
         else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("loadAllScheduleProgramSlots")) {
             Date week = null;
             try {
                
                 week = new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("week"));
            
             } catch (ParseException ex) {
                 Logger.getLogger(ReviewSelectSheduledProgramController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            List<ProgramSlot> programSlotsList = reviewSelectSheduledProgramDelegate.getAllProgramSlots(week);
            JSONArray jsonArray = new JSONArray();
            for (ProgramSlot programSlot : programSlotsList) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("duration", new SimpleDateFormat("HH:mm:ss").format(programSlot.getDuration()));
                    jsonObject.put("id", programSlot.getId());
                     jsonObject.put("dateOfProgram", new SimpleDateFormat("MM/dd/yyyy").format(programSlot.getDateOfProgram()));
                     jsonObject.put("startTime", programSlot.getStartTime());
                     jsonObject.put("radioProgram", programSlot.getRadioProgram().getName());
                     jsonObject.put("presenter", programSlot.getPresenter().getId());
                     jsonObject.put("producer", programSlot.getProducer().getId());
                } catch (JSONException ex) {
                    Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
                }
                jsonArray.put(jsonObject);
            }
            JSONObject jo=new JSONObject();
            try {
                jo.put("programSlots", jsonArray);
            } catch (JSONException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.getWriter().println(jsonArray.toString());
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