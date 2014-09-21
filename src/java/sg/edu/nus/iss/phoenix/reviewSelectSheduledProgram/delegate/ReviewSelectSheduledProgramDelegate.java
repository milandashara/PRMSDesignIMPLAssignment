/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.delegate;

import java.util.Date;
import java.util.List;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.service.ReviewSelectSheduledProgramService;

/**
 *
 * @author mani
 */
public class ReviewSelectSheduledProgramDelegate {
    
            ReviewSelectSheduledProgramService service;

    /**
     *
     */
    public ReviewSelectSheduledProgramDelegate() {
        this.service = new ReviewSelectSheduledProgramService();
    }
       
    /**getAllWeeklySchedule-method. This method invokes the service function 
     * by calling the service method and by passing the year parameter to retrieve
     * a list of weekly schedules
     *
     * @param year
     * @return
     */
    public List<WeeklySchedule> getAllWeeklySchedule(Integer year) {
        return service.getAllWeeklySchedulelist(year);
    }

    /**getAllAnnualScheduleList. This method invokes the service function 
     * by calling the service method to retrieve the list of annual schedule objects.
     *
     * @return
     */
    public List<AnnualSchedule> getAllAnnualScheduleList() {
         return service.getAllAnnualSchedulelist();
    }

    /**getAllProgramSlots. This method invokes the service function 
     * by calling the service method to retrieve the list of schedule program
     * objects based on the week.
     *
     * @param week
     * @return
     */
    public List<ProgramSlot> getAllProgramSlots(Date week) {
        return service.getAllProgramSlots(week);
    }
}