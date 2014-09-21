/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainUser.service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;

/**
 *
 * @author Siva
 */
public class MaintainUserService {

    private UserDao udao;
    private DAOFactoryImpl factory;

    /**
     *
     */
    public MaintainUserService() {
        super();
        factory = new DAOFactoryImpl();
        udao = factory.getUserDAO();
    }

    /**createUser-method. This service method creates a new user and saves 
     * in the database.
     *
     * @param user
     * @return
     */
    public boolean createUser(User user) {

        try {
            udao.create(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**updateUser-method. This service method updates the user data in the database
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        try {
            udao.save(user);
            return true;
        } catch (NotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
/*
*/

    /**deleteUser-method. 
     * Method in service class to delete a user.
     * Returns boolean value as acknowledgement
     * Handles Exceptions-NotFoundException,SQLException
     * Called from MaintainUserDelagate class
     * Calls delete method in user dao
     *
     * @param user
     * @return
     */
    
    public boolean deleteUser(User user) {
        try {
            udao.delete(user);
            return true;
        } catch (NotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /** searchMatching-method. The service method that returns a user match 
     *from the data base.
     *
     * @param uid
     * @return
     */
    public User searchMatching(String uid) {
        try {
            return udao.searchMatching(uid);
        } catch (SQLException ex) {
            Logger.getLogger(MaintainUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new User();
    }

}
