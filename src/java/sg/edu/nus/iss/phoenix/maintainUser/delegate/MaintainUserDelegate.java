/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainUser.delegate;

import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.maintainUser.service.MaintainUserService;

/**
 *
 * @author Siva
 */
public class MaintainUserDelegate {
    
    private MaintainUserService service;
    
    /**
     *
     */
    public MaintainUserDelegate() {
        super();
        service = new MaintainUserService();
    }

    /**createUser-method. This method call invokes a service method to create a
     * user and save into the data base.
     *
     * @param user
     * @return
     */
    public boolean createUser(User user) {
        return service.createUser(user);
    }

    /**updateUser-method. This method call invokes a service method to update a
     * existing user and save in the database.
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        return service.updateUser(user);
    }
// Method in delegate class to delete a user
// Returns boolean value as acknowledgement
// Called from Usercontroller servlet class
// Calls delete user method in service class

    /**deleteUser-method. This method call invokes a service method to delete a
     * existing user from the database.
     *
     * @param user
     * @return
     */
        public boolean deleteUser(User user) {
        return service.deleteUser(user);
    }

    /**searchMatching-method. This method call invokes a service method that returns a
     * existing user with a matching id from the database.
     * @param uid
     * @return
     */
    public User searchMatching(String uid) {
        return service.searchMatching(uid);
    }

}
