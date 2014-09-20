/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import sg.edu.nus.iss.phoenix.maintainSchedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.maintainUser.delegate.MaintainUserDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.RPDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.delegate.ReviewSelectSheduledProgramDelegate;

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
        if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("processScheduledProgramSlot")) {
            try {

                // Preparing the Programslot DTO to perform insert, update or delete operation.
                ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
                ProgramSlot ps = new ProgramSlot();
                RPDelegate rpDelegate = new RPDelegate();
                MaintainUserDelegate userDelegate = new MaintainUserDelegate();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                long parseTime = formatter.parse(request.getParameter("duration")).getTime();

                ps.setDuration(new java.sql.Time(parseTime));
                ps.setId(Integer.parseInt(request.getParameter("id")));
                ps.setDateOfProgram(new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("dateOfProgram")));
                parseTime = formatter.parse(request.getParameter("startTime")).getTime();
                ps.setStartTime(new java.sql.Time(parseTime));
                ps.setRadioProgram(rpDelegate.findRP(request.getParameter("radioProgram")));
                ps.setPresenter(userDelegate.searchMatching(request.getParameter("presenter")));
                ps.setProducer(userDelegate.searchMatching(request.getParameter("producer")));

                String insert = (String) request.getParameter("insert");
                Logger.getLogger(getClass().getName()).log(Level.INFO,
                        "Insert Flag: " + insert);
                if (insert.equalsIgnoreCase("true")) {
                    scheduleDelegate.insertScheduleProgramSlot(ps);
                } else {
                    scheduleDelegate.updateScheduleProgramSlot(ps);
                }
                RequestDispatcher rd = request
                        .getRequestDispatcher("/pages/schedule.jsp");

                rd.forward(request, response);

            } catch (ParseException ex) {
                Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("deleteSchedule")) {
            ScheduleDelegate sd = new ScheduleDelegate();
            ProgramSlot ps = new ProgramSlot();
            String sId = request.getParameter("id");
            Integer id = Integer.parseInt(sId);
            ps.setId(id);
            boolean isDeleted = sd.deleteProgramSlot(ps);
            RequestDispatcher rd;

            if (isDeleted) {
                response.sendRedirect("/PRMS/controller/scheduleScreen");
            } else {
                rd = getServletContext().getRequestDispatcher("/pages/error.jsp");
                rd.forward(request, response);
            }

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