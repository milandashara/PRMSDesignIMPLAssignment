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

    /** getRadioProgramDao-method. This will create a radio program data access implementation 
     * object which contains the data access methods related to the Radio Programs
     *
     * @return
     */
    RadioProgramDAO getRadioProgramDAO();
    
    /** getRoleDAO-method. This will create a role data access implementation 
     * object which contains the data access methods related to the roles.
     *
     * @return
     */
    RoleDao getRoleDAO();

    /** getUserDAO-method. This will create a user data access implementation 
     * object which contains the data access methods related to the users.
     *
     * @return
     */
    UserDao getUserDAO();
        
    /** getAnnualScheduleDAO-method. This will create a annual schedule data 
     * access implementation object which contains the data access methods 
     * related to the Annual schedule objects.
     *
     * @return
     */
    AnnualScheduleDao getAnnualScheduleDAO();
        
    /** getWeeklyScheduleDAO-method. This will create a weekly schedule data 
     * access implementation object which contains the data access methods 
     * related to the Weekly schedule objects.
     *
     * @return
     */
    WeeklyScheduleDao getWeeklyScheduleDAO();
        
    /** getProgramSlotDAO-method. This will create a program slot data 
     * access implementation object which contains the data access methods 
     * related to the schedule program objects.
     *
     * @return
     */
    ProgramSlotDao getProgramSlotDAO();
	
}
