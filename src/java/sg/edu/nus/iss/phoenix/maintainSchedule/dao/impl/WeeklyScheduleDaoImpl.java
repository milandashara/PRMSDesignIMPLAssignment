/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DBUtility;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;

/**
 *
 * @author Mani
 */

public class WeeklyScheduleDaoImpl implements WeeklyScheduleDao{

    Connection connection;

    /**
     *
     */
    public WeeklyScheduleDaoImpl() {
         super();
            connection = DBUtility.openConnection();
    }
    
    
    
    @Override
    public WeeklySchedule createValueObject(Date startDate,String assignedBy) {
        return new WeeklySchedule(startDate, assignedBy);
    }

    @Override
    public WeeklySchedule getObject(Date startDate) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load(WeeklySchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param year
     * @return
     * @throws SQLException
     */
    @Override
    public List<WeeklySchedule> getAllWeeklySchedule(Integer year) throws SQLException
    {
        String sql = "SELECT * FROM phoenix.`weekly-schedule` a where YEAR(a.startDate) ="+year;
		List<WeeklySchedule> searchResults = listQuery(this.connection
				.prepareStatement(sql));
        return searchResults;
    }
    @Override
    public List<WeeklySchedule> loadAll() throws SQLException {
         String sql = "SELECT * FROM `weekly-schedule` ORDER BY year ASC ";
		List<WeeklySchedule> searchResults = listQuery(this.connection
				.prepareStatement(sql));
        return searchResults;
    }

     /**
	 * databaseQuery-method. This method is a helper method for internal use. It
	 * will execute all database queries that will return multiple rows. The
	 * resultset will be converted to the List of valueObjects. If no rows were
	 * found, an empty List will be returned.
	 * 
	 * @param stmt
	 *            This parameter contains the SQL statement to be excuted.
     * @return 
     * @throws java.sql.SQLException 
	 */
	protected List<WeeklySchedule> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<WeeklySchedule> searchResults = new ArrayList<WeeklySchedule>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				WeeklySchedule temp = createValueObject(result.getDate("startDate"),result.getString("assignedBy"));

			
				

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return (List<WeeklySchedule>) searchResults;
	}

    
    @Override
    public void create(WeeklySchedule valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(WeeklySchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(WeeklySchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int countAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WeeklySchedule> searchMatching(WeeklySchedule valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param startDate
     * @return
     * @throws SQLException
     */
    @Override
    public WeeklySchedule searchMatching(Date startDate) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}