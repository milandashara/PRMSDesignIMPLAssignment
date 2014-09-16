/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainSchedule.service;

import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;

/**
 *
 * @author Milan,like
 */
public class ScheduleService {
    
    
	DAOFactoryImpl factory;
	AnnualScheduleDao adao;
	ProgramSlotDao pdao;
        WeeklyScheduleDao wdao;
	public ScheduleService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		adao = factory.getAnnualScheduleDAO();
		pdao = factory.getProgramSlotDAO();
                wdao = factory.getWeeklyScheduleDAO();
	}

        public boolean deleteProgramSlot(ProgramSlot programSlot){
            
            try{
                pdao.delete(programSlot);
                return true;
            }catch( NotFoundException| SQLException e){
                 return false;
            }
      
            
        }
}
