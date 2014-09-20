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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.core.dao.DBUtility;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.RadioProgramDAOImpl;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Milan
 */
public class ProgramSlotDaoImpl implements ProgramSlotDao {

    Connection connection;

    public ProgramSlotDaoImpl() {
        super();
        connection = DBUtility.openConnection();
    }

    @Override
    public ProgramSlot createValueObject(Time duration, Integer id,
            Date dateOfProgram,
            Time startTime,
            RadioProgram radioProgram,
            User presenter,
            User producer) {
        return new ProgramSlot(duration, id, dateOfProgram, startTime,
                radioProgram, presenter, producer);
    }

    @Override
    public ProgramSlot getObject(Date dateAndTimeOfProgram) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProgramSlot getObject(Integer id)
            throws NotFoundException, SQLException {
        return null;
    }

    @Override
    public void load(ProgramSlot valueObject) throws NotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProgramSlot> loadAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(ProgramSlot valueObject) throws SQLException {
       		String sql = "";
		PreparedStatement stmt = null;
		try {
			sql = "INSERT INTO `program-slot` (`duration`, `dateOfProgram`, `startTime`,`programName`, `presenter`, `producer`) VALUES (?,?,?,?,?,?); ";
			stmt = this.connection.prepareStatement(sql);
                  stmt.setTime(1, valueObject.getStartTime());
            stmt.setDate(2, new java.sql.Date(valueObject.getDateOfProgram().getTime()));
            stmt.setDate(3, new java.sql.Date(valueObject.getStartTime().getTime()));
            stmt.setString(4, valueObject.getRadioProgram().getName());
            stmt.setString(5, valueObject.getPresenter().getId());
            stmt.setString(6, valueObject.getProducer().getId());
            stmt.setInt(6, valueObject.getId());;
			int rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		
		}
    }

    @Override
    public void save(ProgramSlot valueObject) throws NotFoundException, SQLException {
         String sql = "UPDATE `program-slot` SET `duration`= ? , `dateOfProgram` = ?, `startTime` = ? , `programName` = ? , `presenter` = ? , `producer` = ? WHERE (`id` = ? );";
        PreparedStatement stmt = null;
        try {
   
            stmt = this.connection.prepareStatement(sql);
            stmt.setTime(1, valueObject.getStartTime());
            stmt.setDate(2, new java.sql.Date(valueObject.getDateOfProgram().getTime()));
            stmt.setDate(3, new java.sql.Date(valueObject.getStartTime().getTime()));
            stmt.setString(4, valueObject.getRadioProgram().getName());
            stmt.setString(5, valueObject.getPresenter().getId());
            stmt.setString(6, valueObject.getProducer().getId());
            stmt.setInt(7, valueObject.getId());
            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be updated! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were updated!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
//written by li ke

    @Override
    public void delete(ProgramSlot valueObject) throws NotFoundException, SQLException {
        String sql = "DELETE FROM `program-slot` WHERE (id = ? ) ";
        PreparedStatement stmt = null;
        try {
            stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, valueObject.getId());
            int rowcount = databaseUpdate(stmt);
            if (rowcount == 0) {
                // System.out.println("Object could not be deleted (PrimaryKey not found)");
                throw new NotFoundException(
                        "Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                // System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                throw new SQLException(
                        "PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
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
    public List<ProgramSlot> searchMatching(ProgramSlot valueObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProgramSlot searchMatching(Date dateOfProgram, Time startTime) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * databaseUpdate-method. This method is a helper method for internal use.
     * It will execute all database handling that will change the information in
     * tables. SELECT queries will not be executed here however. The return
     * value indicates how many rows were affected. This method will also make
     * sure that if cache is used, it will reset when data changes.
     *
     * @param conn This method requires working database connection.
     * @param stmt This parameter contains the SQL statement to be excuted.
     */
    protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

        int result = stmt.executeUpdate();

        return result;
    }

    @Override
    public List<ProgramSlot> getAllProgramSlots(Date week) throws SQLException {
        String sql = "SELECT * FROM phoenix.`program-slot` a where dateOfProgram BETWEEN ? and ADDDATE(?,7)";
        PreparedStatement stmt = null;
        List<ProgramSlot> searchResults = null;
        try {
            java.sql.Date sqlDate = new java.sql.Date(week.getTime());
            stmt = this.connection.prepareStatement(sql);
            stmt.setDate(1, sqlDate);
            stmt.setDate(2, sqlDate);
            searchResults = listQuery(stmt);
        } catch (NotFoundException ex) {
            Logger.getLogger(ProgramSlotDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchResults;
    }

    protected List<ProgramSlot> listQuery(PreparedStatement stmt) throws SQLException, NotFoundException {

        ArrayList<ProgramSlot> searchResults = new ArrayList<ProgramSlot>();
        RadioProgramDAO rpDao = new RadioProgramDAOImpl();
        UserDao userDao = new UserDaoImpl();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                RadioProgram rpTemp = rpDao.getObject(result.getString(DBConstants.ps_programName));
                User presenterTemp = userDao.getObject(result.getString(DBConstants.ps_presenter));
                User producerTemp = userDao.getObject(result.getString(DBConstants.ps_producer));
                ProgramSlot temp = createValueObject(result.getTime(DBConstants.ps_duration),result.getInt(DBConstants.ps_id), result.getDate(DBConstants.ps_dateOfProgram),result.getTime(DBConstants.ps_startTime),rpTemp, presenterTemp, producerTemp);

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

        return searchResults;
    }

}