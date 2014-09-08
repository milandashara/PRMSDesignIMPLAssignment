/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectUser.delegate;

import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.reviewSelectUser.service.UserListService;

/**
 *
 * @author Siva
 */
public class UserListDelegate {

    public ArrayList<User> getUserList() {
        UserListService service=new UserListService();
        return service.getUserList();
    }
    
}
