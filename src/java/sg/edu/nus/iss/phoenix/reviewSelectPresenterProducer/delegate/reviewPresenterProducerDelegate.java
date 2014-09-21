/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.entity.PresenterProducer;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.service.reviewPresenterProducerService;

/**
 *
 * @author sakthi
 */
public class reviewPresenterProducerDelegate {

    /**getAllPresenterProducer-method. This method calls the service function which
     * returns a list of presenters or producers based on the role parameter passed.
     *
     * @param role
     * @return
     * @throws SQLException
     */
    public ArrayList<PresenterProducer> getAllPresenterProducer(String role) throws SQLException {
		reviewPresenterProducerService service = new reviewPresenterProducerService();
		return service.getAllPresenterProducer(role);
		
	}   
}
