/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainUser.delegate;

import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.maintainUser.service.MaintainUserService;

/**
 *
 * @author Siva
 */
public class MaintainUserDelegate {
    
    public void deleteUser(User u) {
		MaintainUserService service=new MaintainUserService();
		service.deleteUser(u);
	}
    
}
