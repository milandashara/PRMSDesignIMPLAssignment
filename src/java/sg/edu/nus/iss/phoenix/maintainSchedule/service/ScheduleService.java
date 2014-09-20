/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;

/**
 *
 * @author Milan,like
 */
public class ScheduleService {

    DAOFactoryImpl factory;
    AnnualScheduleDao annualScheduleDao;
    ProgramSlotDao programSlotDao;
    WeeklyScheduleDao weeklyScheduleDao;

    public ScheduleService() {
        super();
        // TODO Auto-generated constructor stub
        factory = new DAOFactoryImpl();
        annualScheduleDao = factory.getAnnualScheduleDAO();
        programSlotDao = factory.getProgramSlotDAO();
        weeklyScheduleDao = factory.getWeeklyScheduleDAO();
    }

    public List<AnnualSchedule> getAllAnnualSchedulelist() {
        try {
            return annualScheduleDao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<AnnualSchedule>();
    }

    public List<WeeklySchedule> getAllWeeklySchedulelist(Integer year) {
        try {

            return weeklyScheduleDao.getAllWeeklySchedule(year);

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<WeeklySchedule>();
    }

    public boolean deleteProgramSlot(ProgramSlot programSlot) {

        try {
            programSlotDao.delete(programSlot); 
        } catch (NotFoundException | SQLException e) {
            return false;
        }
        return true;
    }

    private void getObject(Integer year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertScheduleProgramSlot(ProgramSlot ps) {
        try {
            programSlotDao.create(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateScheduleProgramSlot(ProgramSlot ps) {
        
        try {
            programSlotDao.save(ps);
        } catch (NotFoundException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}