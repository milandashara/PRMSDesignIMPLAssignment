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

    /**
     *
     * @param programSlot
     * @return
     */
    public boolean deleteProgramSlot(ProgramSlot programSlot) {

        return service.deleteProgramSlot(programSlot);
    }

    /**
     *
     * @return
     */
    public List<AnnualSchedule> getAllAnnualScheduleList() {
        return service.getAllAnnualSchedulelist();
    }

    /**
     *
     * @param year
     * @return
     */
    public List<WeeklySchedule> getAllWeeklySchedule(Integer year) {
        return service.getAllWeeklySchedulelist(year);
    }

    /**
     *
     * @param ps
     */
    public void insertScheduleProgramSlot(ProgramSlot ps) {
        service.insertScheduleProgramSlot(ps);
    }

    /**
     *
     * @param ps
     */
    public void updateScheduleProgramSlot(ProgramSlot ps) {
         service.updateScheduleProgramSlot(ps);
    }

    /**
     *
     * @return
     */
    public List<RadioProgram> getAllRadioProgram() {
       return service.getAllRadioProgram();
    }

    /**
     *
     * @param user
     * @return
     */
    public User findUser(String user) {
        return service.findUser(user);
    }

    /**
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

    /**
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

    /**
     *
     * @param programSlot
     * @param week
     * @return
     */
    public String checkTimeSlotConstraint(ProgramSlot programSlot,String week) {
        
       return service.checkTimeSlotConstraint(programSlot, week);
    }

    /**
     *
     * @param programSlot
     */
    public void createSchedule(ProgramSlot programSlot) {
        service.createSchedule(programSlot);
    }

    /**
     *
     * @param programSlotId
     * @return
     */
    public ProgramSlot findProgramSlot(Integer programSlotId) {
        return service.findProgramSlot(programSlotId);
    }

   
}