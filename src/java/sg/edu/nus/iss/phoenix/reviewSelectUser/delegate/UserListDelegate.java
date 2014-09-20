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

    public ArrayList<User> getUserList() {
        return service.getUserList();
    }
    
    public ArrayList<String> getUserList(String role) {
        return service.getUserList(role);
    }

    public List<Role> getRoleList() {
        return service.getRoleList();
    }
    
    

}
