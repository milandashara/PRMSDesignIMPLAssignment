/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectUser.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;


/**
 *
 * @author Siva
 */
public class UserListService {
    DAOFactoryImpl factory;
    UserDao udao;
    
    public UserListService(){
        super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
                udao=factory.getUserDAO();
    }
    
    
    public ArrayList<User> getUserList() {
       ArrayList<User> currentList = new ArrayList<User>();
		try {
			currentList = (ArrayList<User>) udao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;
        
    }
    
}
