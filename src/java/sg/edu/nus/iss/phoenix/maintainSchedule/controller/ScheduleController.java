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
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
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
        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("createSchedule")) {

            ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
            List<RadioProgram> radioProgramList = scheduleDelegate.getAllRadioProgram();

            request.setAttribute("weeklySchedule", request.getParameter("weeklySchedule"));
            request.setAttribute("annualScheduleYear", request.getParameter("annualScheduleYear"));
            request.setAttribute("radioProgramList", radioProgramList);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createSchedule.jsp");
            rd.forward(request, response);
        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("createScheduleSubmit")) {

            String hr = request.getParameter("createProgramDurationHr").substring(0, request.getParameter("createProgramDurationHr").length() - 2);
            String mt = request.getParameter("createProgramDurationMt").substring(0, request.getParameter("createProgramDurationMt").length() - 2);
            String startTimeHr = request.getParameter("createStartTimeHr").substring(0, request.getParameter("createStartTimeHr").length() - 2);
            String startTimetMt = request.getParameter("createStartTimeMt").substring(0, request.getParameter("createStartTimeMt").length() - 2);
            String programName = request.getParameter("createProgramName");
            String presenterStr = request.getParameter("createPresenter");
            String producerStr = request.getParameter("createProducer");
            String dateOfProgramStr = request.getParameter("createDateOfProgram");
            String week = request.getParameter("weeklySchedule");
            String year = request.getParameter("annualScheduleYear");

            ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
            String errorMessage = scheduleDelegate.validate(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr, week);
            if (!errorMessage.equals("success")) {
                request.setAttribute("errorMessage", errorMessage);
                request.setAttribute("annualScheduleYear", year);
                request.setAttribute("createPresenter", presenterStr);
                request.setAttribute("createProducer", producerStr);
                request.setAttribute("weeklySchedule", week);
                List<RadioProgram> radioProgramList = scheduleDelegate.getAllRadioProgram();
                request.setAttribute("radioProgramList", radioProgramList);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createSchedule.jsp");
                rd.forward(request, response);

            } else {

                ProgramSlot programSlot = scheduleDelegate.getProgramSlot(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr);

                errorMessage = scheduleDelegate.checkTimeSlotConstraint(programSlot, week);
                if (errorMessage.equals("success")) {
                    scheduleDelegate.createSchedule(programSlot);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ReviewSelectSheduledProgramController/loadAllAnnualSchedule");
                    request.setAttribute("createSuccessMsg", "Schedule Created successfully");
                    rd.forward(request, response);
                } else {

                    request.setAttribute("errorMessage", errorMessage);
                    request.setAttribute("annualScheduleYear", year);
                    request.setAttribute("createPresenter", presenterStr);
                    request.setAttribute("createProducer", producerStr);
                    request.setAttribute("weeklySchedule", week);
                    List<RadioProgram> radioProgramList = scheduleDelegate.getAllRadioProgram();
                    request.setAttribute("radioProgramList", radioProgramList);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createSchedule.jsp");
                    rd.forward(request, response);
                }
            }
        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("modifyCopyProgramSlot")) {
            String week = request.getParameter("weeklySchedule");
            String year = request.getParameter("annualScheduleYear");
            String programSlotId = request.getParameter("id");
            String modifyOrCopy = request.getParameter("insert");
            ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
            ProgramSlot programSlot = scheduleDelegate.findProgramSlot(Integer.parseInt(programSlotId));
            request.setAttribute("annualScheduleYear", year);
            request.setAttribute("weeklySchedule", week);
            request.setAttribute("programSlotId", programSlot.getId());
            request.setAttribute("modifyStartTimeMt", programSlot.getStartTime().getMinutes() + "mt");
            request.setAttribute("modifyStartTimeHr", programSlot.getStartTime().getHours() + "hr");
            request.setAttribute("createProgramDurationMt", programSlot.getDuration().getMinutes() + "mt");
            request.setAttribute("createProgramDurationHr", programSlot.getDuration().getHours() + "hr");
            request.setAttribute("modifyOrCopy", modifyOrCopy);
            RPDelegate rpDelegate = new RPDelegate();
            List<RadioProgram> radioProgramList = rpDelegate.findAllRP();
            request.setAttribute("radioProgramList", radioProgramList);
            request.setAttribute("radioProgramSelected", programSlot.getRadioProgram());
            request.setAttribute("createPresenter", programSlot.getPresenter().getId());
            request.setAttribute("createProducer", programSlot.getProducer().getId());
            request.setAttribute("modifyDateOfProgram", new SimpleDateFormat("MM/dd/yyyy").format(programSlot.getDateOfProgram()));

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/modifyCopyProgramSlot.jsp");
            rd.forward(request, response);

        } else if (FCUtilities.stripPath(request.getPathInfo()).equalsIgnoreCase("modifyScheduleSubmit")) {
            
            String hr = request.getParameter("createProgramDurationHr").substring(0, request.getParameter("createProgramDurationHr").length() - 2);
            String mt = request.getParameter("createProgramDurationMt").substring(0, request.getParameter("createProgramDurationMt").length() - 2);
            String startTimeHr = request.getParameter("modifyStartTimeHr").substring(0, request.getParameter("modifyStartTimeHr").length() - 2);
            String startTimetMt = request.getParameter("modifyStartTimeMt").substring(0, request.getParameter("modifyStartTimeMt").length() - 2);
            String programName = request.getParameter("modifyProgramName");
            String presenterStr = request.getParameter("createPresenter");
            String producerStr = request.getParameter("createProducer");
            String dateOfProgramStr = request.getParameter("modifyDateOfProgram");
            String week = request.getParameter("weeklySchedule");
            String year = request.getParameter("annualScheduleYear");
            String programSlotId=request.getParameter("programSlotId");
            String insert = request.getParameter("insert");

            ScheduleDelegate scheduleDelegate = new ScheduleDelegate();
            String errorMessage = scheduleDelegate.validate(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr, week);
            if (!errorMessage.equals("success")) {
                request.setAttribute("errorMessage", errorMessage);
                request.setAttribute("annualScheduleYear", year);
                request.setAttribute("createPresenter", presenterStr);
                request.setAttribute("createProducer", producerStr);
                request.setAttribute("weeklySchedule", week);
                List<RadioProgram> radioProgramList = scheduleDelegate.getAllRadioProgram();
                request.setAttribute("radioProgramList", radioProgramList);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createSchedule.jsp");
                rd.forward(request, response);

            } else {
                ProgramSlot programSlot = scheduleDelegate.getProgramSlot(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr);
                programSlot.setId(Integer.parseInt(programSlotId));
                errorMessage = scheduleDelegate.checkTimeSlotConstraint(programSlot, week);
                if (errorMessage.equals("success")) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/ReviewSelectSheduledProgramController/loadAllAnnualSchedule");
                    if(insert.equalsIgnoreCase("false"))
                    {
                    scheduleDelegate.updateScheduleProgramSlot(programSlot);
                    request.setAttribute("createSuccessMsg", "Schedule Updated successfully");
                    }
                    else
                    {
                      scheduleDelegate.createSchedule(programSlot);
                      request.setAttribute("createSuccessMsg", "Schedule Created successfully");
                    }
                   
                    
                    rd.forward(request, response);
                } else {

                    request.setAttribute("errorMessage", errorMessage);
                    request.setAttribute("annualScheduleYear", year);
                    request.setAttribute("createPresenter", presenterStr);
                    request.setAttribute("createProducer", producerStr);
                    request.setAttribute("weeklySchedule", week);
                    List<RadioProgram> radioProgramList = scheduleDelegate.getAllRadioProgram();
                    request.setAttribute("radioProgramList", radioProgramList);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createSchedule.jsp");
                    rd.forward(request, response);
                }
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
