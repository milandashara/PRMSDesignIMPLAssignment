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

    public ReviewSelectSheduledProgramDelegate() {
        this.service = new ReviewSelectSheduledProgramService();
    }
       
         public List<WeeklySchedule> getAllWeeklySchedule(Integer year) {
        return service.getAllWeeklySchedulelist(year);
    }

    public List<AnnualSchedule> getAllAnnualScheduleList() {
         return service.getAllAnnualSchedulelist();
    }

    public List<ProgramSlot> getAllProgramSlots(Date week) {
        return service.getAllProgramSlots(week);
    }
}