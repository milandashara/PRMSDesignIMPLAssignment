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
import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;

/**
 *
 * @author Siva
 */
public class UserListService {

    private DAOFactoryImpl factory;
    private RoleDao roleDao;
    private UserDao udao;

    /**
     *
     */
    public UserListService() {
        super();
        factory = new DAOFactoryImpl();
        udao = factory.getUserDAO();
        roleDao = factory.getRoleDAO();
    }
  

    /**getUserList-method. Method of service class to fetch the list of users 
     * from the db Returns a arraylist of user objects handles sql exception.
     *

     * @return
     */
    public ArrayList<User> getUserList() {
        ArrayList<User> userList = new ArrayList();
        try {
            userList = (ArrayList<User>) udao.loadAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userList;
    }

    /**getRoleList-method. This service method retrieves all the role list from
     * the database.
     *
     * @return
     */
    public List<Role> getRoleList() {
        List<Role> roleList = new ArrayList();
        try {
            roleList = roleDao.loadAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;

    }

    /**getUserList-method. This service method returns a list of users based on
     * the role that is provided as parameter
     *
     * @param role
     * @return
     */
    public ArrayList<String> getUserList(String role) {
        ArrayList<User> currentList = new ArrayList<User>();
        ArrayList<String> currentIdList = new ArrayList<String>();
        try {
            currentList = (ArrayList<User>) udao.loadAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (User u : currentList) {
            for (Role r : u.getRoles()) {
                if (r.getRole() == role) {
                    currentIdList.add(u.getId());
                }
            }
        }
        return currentIdList;

    }

}
