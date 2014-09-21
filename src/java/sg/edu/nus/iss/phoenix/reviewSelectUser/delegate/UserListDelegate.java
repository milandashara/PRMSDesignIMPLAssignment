/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.reviewSelectUser.delegate;

import java.util.ArrayList;
import java.util.List;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.reviewSelectUser.service.UserListService;

/**
 *
 * @author Siva
 */
public class UserListDelegate {

    private UserListService service = new UserListService();
    
    //Method of delegate class to fetch the list of users from the db
//Returns a arraylist of user objects

    /**getUserList-method. Method of delegate class to fetch the list of users 
     * from the db Returns a arraylist of user objects.
     *
     * @return
     */
    
    public ArrayList<User> getUserList() {
        return service.getUserList();
    }
    
    /**getUserList-method. This delegate method calls the service function which
     * retrieves all the user list based on their role from the database
     *
     * @param role
     * @return
     */
    public ArrayList<String> getUserList(String role) {
        return service.getUserList(role);
    }

    /**getRoleList-method. This delegate method calls the service function which
     * retrieves all the role list from the database.
     *
     * @return
     */
    public List<Role> getRoleList() {
        return service.getRoleList();
    }
    
    

}
