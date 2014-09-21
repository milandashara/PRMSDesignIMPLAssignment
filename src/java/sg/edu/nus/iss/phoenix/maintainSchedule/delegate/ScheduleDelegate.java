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

    public ScheduleDelegate() {
        super();
        service = new ScheduleService();
    }

    public boolean deleteProgramSlot(ProgramSlot programSlot) {

        return service.deleteProgramSlot(programSlot);
    }

    public List<AnnualSchedule> getAllAnnualScheduleList() {
        return service.getAllAnnualSchedulelist();
    }

    public List<WeeklySchedule> getAllWeeklySchedule(Integer year) {
        return service.getAllWeeklySchedulelist(year);
    }

    public void insertScheduleProgramSlot(ProgramSlot ps) {
        service.insertScheduleProgramSlot(ps);
    }

    public void updateScheduleProgramSlot(ProgramSlot ps) {
         service.updateScheduleProgramSlot(ps);
    }

    public List<RadioProgram> getAllRadioProgram() {
       return service.getAllRadioProgram();
    }

    public User findUser(String user) {
        return service.findUser(user);
    }

    public String validate(String hr, String mt, String startTimeHr, String startTimetMt,String dateOfProgramStr, String programName, String presenterStr, String producerStr,String week) {
        return service.validate(hr, mt, startTimeHr, startTimetMt,dateOfProgramStr, programName, presenterStr, producerStr, week);
        
    }

    public ProgramSlot getProgramSlot(String hr, String mt, String startTimeHr, String startTimetMt, String dateOfProgramStr, String programName, String presenterStr, String producerStr) {
        return service.createProgramSlotObject(hr, mt, startTimeHr, startTimetMt, dateOfProgramStr, programName, presenterStr, producerStr);
    }

    public String checkTimeSlotConstraint(ProgramSlot programSlot,String week) {
        
       return service.checkTimeSlotConstraint(programSlot, week);
    }

    public void createSchedule(ProgramSlot programSlot) {
        service.createSchedule(programSlot);
    }

    public ProgramSlot findProgramSlot(Integer programSlotId) {
        return service.findProgramSlot(programSlotId);
    }

   
}