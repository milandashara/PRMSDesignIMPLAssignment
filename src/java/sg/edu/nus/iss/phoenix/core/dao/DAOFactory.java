/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;

/**
 *
 * @author projects
 */
public interface DAOFactory {

	RadioProgramDAO getRadioProgramDAO();

	RoleDao getRoleDAO();

	UserDao getUserDAO();
        
        AnnualScheduleDao getAnnualScheduleDAO();
        
        WeeklyScheduleDao getWeeklyScheduleDAO();
        
        ProgramSlotDao getProgramSlotDAO();
	
}
