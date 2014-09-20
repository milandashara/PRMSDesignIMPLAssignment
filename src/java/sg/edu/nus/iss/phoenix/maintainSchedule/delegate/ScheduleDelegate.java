/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.delegate;

import java.util.List;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.service.ScheduleService;

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
}