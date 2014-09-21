/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.dao.DBUtility;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;

/**
 *
 * @author Mani
 */
public class AnnualScheduleDaoImpl implements AnnualScheduleDao {

    private static final Logger logger = Logger.getLogger(AnnualScheduleDaoImpl.class.getName());

    Connection connection;

    /**
     *
     */
    public AnnualScheduleDaoImpl() {
        super();
        connection = DBUtility.openConnection();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#createValueObject
     * 
     */
    @Override
    public AnnualSchedule createValueObject(Integer year, String assignedBy) {
        return new AnnualSchedule(year, assignedBy); //To change body of generated methods, choose Tools | Templates.
    }
    
     /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#getObject
     * 
     */

    @Override
    public AnnualSchedule getObject(Integer year) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM `annual-schedule` where year=" + year + "ORDER BY year ASC ";

        List<AnnualSchedule> searchResults = listQuery(this.connection
                .prepareStatement(sql));
        if (searchResults.size() > 0) {
            return searchResults.get(0);
        } else {
            return null;
        }

    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#load
     * 
     */

    @Override
    public void load(AnnualSchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#loadAll
     * 
     */

    @Override
    public List<AnnualSchedule> loadAll() throws SQLException {
        String sql = "SELECT * FROM `annual-schedule` ORDER BY year ASC ";
        List<AnnualSchedule> searchResults = listQuery(this.connection
                .prepareStatement(sql));
        return searchResults;
    }

    /**
     * databaseQuery-method. This method is a helper method for internal use. It
     * will execute all database queries that will return multiple rows. The
     * resultset will be converted to the List of valueObjects. If no rows were
     * found, an empty List will be returned.
     *
     * @param stmt This parameter contains the SQL statement to be excuted.
     * @return 
     * @throws java.sql.SQLException 
     */
    protected List<AnnualSchedule> listQuery(PreparedStatement stmt) throws SQLException {

        ArrayList<AnnualSchedule> searchResults = new ArrayList<AnnualSchedule>();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                AnnualSchedule temp = createValueObject(result.getInt("year"), result.getString("assingedBy"));

                searchResults.add(temp);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

        return (List<AnnualSchedule>) searchResults;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#create
     * 
     */

    @Override
    public void create(AnnualSchedule valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#save
     * 
     */
    @Override
    public void save(AnnualSchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#delete
     * 
     */
    @Override
    public void delete(AnnualSchedule valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#deleteAll
     * 
     */

    @Override
    public void deleteAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#countAll
     * 
     */

    @Override
    public int countAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#searchMatching
     * 
     */

    @Override
    public List<AnnualSchedule> searchMatching(AnnualSchedule valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     /*
     * (non-Javadoc)
     * 
     * @see
     * sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDao#searchMatching
     * 
     *
     * @param year
     * @return
     * @throws SQLException
     */
    @Override
    public AnnualSchedule searchMatching(Integer year) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param stmt
     * @param valueObject
     * @throws NotFoundException
     * @throws SQLException
     */
    protected void singleQuery(PreparedStatement stmt, AnnualSchedule valueObject)
            throws NotFoundException, SQLException {

    }

}