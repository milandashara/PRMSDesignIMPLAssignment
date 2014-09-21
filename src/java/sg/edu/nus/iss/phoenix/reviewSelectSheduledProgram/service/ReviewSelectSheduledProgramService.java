/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectSheduledProgram.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactory;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.ProgramSlotDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.WeeklyScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.service.ScheduleService;

/**
 *
 * @author mani
 */
public class ReviewSelectSheduledProgramService {

    DAOFactory factory;
    AnnualScheduleDao annualScheduleDao;
    ProgramSlotDao programSlotDao;
    WeeklyScheduleDao weeklyScheduleDao;
    
    /**
     *
     */
    public ReviewSelectSheduledProgramService() {
        super();
        this.factory = new DAOFactoryImpl();
        this.annualScheduleDao = new AnnualScheduleDaoImpl();
        this.programSlotDao = new ProgramSlotDaoImpl();
        this.weeklyScheduleDao = new WeeklyScheduleDaoImpl();
    }
    
    /**getAllAnnualSchedulelist-method. This service method retrieves a list of 
     * Annual schedules from the database.
     *
     * @return
     */
    public List<AnnualSchedule> getAllAnnualSchedulelist() {
                try {
            return annualScheduleDao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<AnnualSchedule>(); 
    }

    /**getAllWeeklySchedulelist-method. This service method by passing the year 
     * parameter retrieves a list of weekly schedules
     *
     * @param year
     * @return
     */
    public List<WeeklySchedule> getAllWeeklySchedulelist(Integer year) {
        try {

            return weeklyScheduleDao.getAllWeeklySchedule(year);

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<WeeklySchedule>();
    }

    /**getAllProgramSlots-method. This service method by passing the wyeareek 
     * parameter retrieves a list of Program schedule slots.
     *
     * @param week
     * @return
     */
    public List<ProgramSlot> getAllProgramSlots(Date week) {
                try {

            return programSlotDao.getAllProgramSlots(week);

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<ProgramSlot>();
    }
    
}