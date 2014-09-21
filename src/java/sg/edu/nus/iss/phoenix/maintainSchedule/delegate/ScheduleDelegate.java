/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.service.ScheduleService;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Milan
 */
public class ScheduleDelegate {

    ScheduleService service;

    /**
     *
     */
    public ScheduleDelegate() {
        super();
        service = new ScheduleService();
    }

    /**deleteProgramSlot-method. This method deletes the program slot which is
     * passed as argument from the database.
     *
     * @param programSlot
     * @return
     */
    public boolean deleteProgramSlot(ProgramSlot programSlot) {

        return service.deleteProgramSlot(programSlot);
    }

    /**getAllAnnualScheduleList-method. This method calls the service function
     * which returns a list of all the annual schedule objects.
     *
     * @return
     */
    public List<AnnualSchedule> getAllAnnualScheduleList() {
        return service.getAllAnnualSchedulelist();
    }

    /**getAllWeeklySchedule-method. This method returns the list of weekly 
     * schedules when a year is passed as argument.
     *
     * @param year
     * @return
     */
    public List<WeeklySchedule> getAllWeeklySchedule(Integer year) {
        return service.getAllWeeklySchedulelist(year);
    }

    /**insertScheduleProgramSlot-method. This method calls the method of the 
     * service which inserts a program slot into the database.
     *
     * @param ps
     */
    public void insertScheduleProgramSlot(ProgramSlot ps) {
        service.insertScheduleProgramSlot(ps);
    }

    /**updateScheduleProgramSlot-method. This method updates the program slot details
     * in the database.
     * 
     *
     * @param ps
     */
    public void updateScheduleProgramSlot(ProgramSlot ps) {
         service.updateScheduleProgramSlot(ps);
    }

    /**getAllRadioProgram-method. This method returns a list of radio programs
     *
     * @return
     */
    public List<RadioProgram> getAllRadioProgram() {
       return service.getAllRadioProgram();
    }

    /**findUser-method. This method calls the service to retrieve a particular user 
     * object when a user id is passed as argument.
     *
     * @param user
     * @return
     */
    public User findUser(String user) {
        return service.findUser(user);
    }

    /**validate-method. This method calls the service method which performs other
     * business validations apart from the time slot constraint validations.
     *
     * @param hr
     * @param mt
     * @param startTimeHr
     * @param startTimetMt
     * @param dateOfProgramStr
     * @param programName
     * @param presenterStr
     * @param producerStr
     * @param week
     * @return
     */
    public String validate(String hr, String mt, String startTimeHr, String startTimetMt,String dateOfProgramStr, String programName, String presenterStr, String producerStr,String week) {
        return service.validate(hr, mt, startTimeHr, startTimetMt,dateOfProgramStr, programName, presenterStr, producerStr, week);
        
    }

    /**getProgramSlot-method. This method calls the method of service 
     * which returns a program slot with all the attributes assigned to it. 
     * 
     * All the attribute objects of the program slot object are loaded from this call.
     *
     * @param hr
     * @param mt
     * @param startTimeHr
     * @param startTimetMt
     * @param dateOfProgramStr
     * @param programName
     * @param presenterStr
     * @param producerStr
     * @return
     */
    public ProgramSlot getProgramSlot(String hr, String mt, String startTimeHr, String startTimetMt, String dateOfProgramStr, String programName, String presenterStr, String producerStr) {
        return service.createProgramSlotObject(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr);
    }

    /**checkTimeSlotConstraint-method. This method performs the business 
     * validations related to the program slot.
     *
     * @param programSlot
     * @param week
     * @return
     */
    public String checkTimeSlotConstraint(ProgramSlot programSlot,String week) {
        
       return service.checkTimeSlotConstraint(programSlot, week);
    }

    /**createSchedule-method. This method calls the service method which creates
     * a program slot and saves it in the database.
     *
     * @param programSlot
     */
    public void createSchedule(ProgramSlot programSlot) {
        service.createSchedule(programSlot);
    }

    /**findProgramSlot-method. To call the method of the service which returns
     * a program slot based on the program slot id.
     *
     * @param programSlotId
     * @return
     */
    public ProgramSlot findProgramSlot(Integer programSlotId) {
        return service.findProgramSlot(programSlotId);
    }

   
}