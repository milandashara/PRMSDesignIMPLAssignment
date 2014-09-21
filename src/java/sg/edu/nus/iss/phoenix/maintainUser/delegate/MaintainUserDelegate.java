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

    private MaintainUserService service = new MaintainUserService();

    public void createUser(User user) {
        service.createUser(user);
    }

    public void updateUser(User user) {
        service.updateUser(user);
    }

    public boolean deleteUser(User user) {
        return service.deleteUser(user);
    }

    public User searchMatching(String uid) {
        return service.searchMatching(uid);
    }

}
