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

    public MaintainUserService() {
        super();
        factory = new DAOFactoryImpl();
        udao = factory.getUserDAO();
    }

    public void createUser(User user) {
        try {
            udao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            udao.save(user);
        } catch (NotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteUser(User user) {
        try {
            udao.delete(user);
            return true;
        } catch (NotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
      public User searchMatching(String uid) 
    {
                  try {
                      return udao.searchMatching(uid);
                  } catch (SQLException ex) {
                      Logger.getLogger(MaintainUserService.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  return new User();
    }
    

}
