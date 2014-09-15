/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainUser.service;

import java.sql.SQLException;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;

/**
 *
 * @author Siva
 */
public class MaintainUserService {
              UserDao udao;
              DAOFactoryImpl factory;
              
              public MaintainUserService(){
                super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
                udao=factory.getUserDAO();
    }
              
              
    public void deleteUser(User u) {
try {
				udao.delete(u);
		} catch (NotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
}
