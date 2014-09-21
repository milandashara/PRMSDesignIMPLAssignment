/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.core.dao.DBConstants;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao.ReviewSelectPresenterProducerDAO;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.entity.PresenterProducer;

/**
 *
 * @author sakthi
 */
public class ReviewSelectPresenterProducerDAOImpl  implements  ReviewSelectPresenterProducerDAO{
    Connection connection;
    
    /**
     *
     * @return
     */
    @Override
	public PresenterProducer createValueObject() {
		return new PresenterProducer();
	}  
	
    /**
     *
     * @param stmt
     * @return
     * @throws SQLException
     */
    protected List<PresenterProducer> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<PresenterProducer> searchResults = new ArrayList<PresenterProducer>();
		ResultSet result = null;
		openConnection();
		try {
			result = stmt.executeQuery();

			while (result.next()) {
				PresenterProducer temp = createValueObject();

				temp.setName(result.getString("name"));
				temp.setId(result.getString("id"));
				temp.setRole(result.getString("role"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
			closeConnection();
		}

		return (List<PresenterProducer>) searchResults;
	}

	private void openConnection() {
		try {
			Class.forName(DBConstants.COM_MYSQL_JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.connection = DriverManager.getConnection(DBConstants.dbUrl,
					DBConstants.dbUserName, DBConstants.dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     *
     * @param role
     * @return
     * @throws SQLException
     */
    @Override
    public List<PresenterProducer> getAllPresenterProducer(String role) throws SQLException {
                openConnection();
		String sql = "select U.id,U.name,U.role from user U   where U.role like '%"+role+"%' ORDER BY `name` ASC; ";
                PreparedStatement stmt = connection.prepareStatement(sql);
            
		List<PresenterProducer> searchResults = listQuery(stmt);
		closeConnection();
		System.out.println("record size"+searchResults.size());
		return searchResults;
    }
    
}
