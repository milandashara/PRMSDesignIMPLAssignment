/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.service;

import java.sql.SQLException;
import java.util.ArrayList;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao.ReviewSelectPresenterProducerDAO;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.entity.PresenterProducer;

/**
 *
 * @author sakthi
 */
public class reviewPresenterProducerService {
    
    DAOFactoryImpl factory;
	ReviewSelectPresenterProducerDAO ppdao;

    /**
     *
     */
    public reviewPresenterProducerService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		ppdao = factory.getReviewSelectPresenterProducerDAO();
	}

    /** getAllPresenterProducer-method. This service method retrieved all the
     * presenters or producers based on the role parameter passed as argument.
     *
     * @param role
     * @return
     * @throws SQLException
     */
    public ArrayList<PresenterProducer> getAllPresenterProducer(String role) throws SQLException {
		ArrayList<PresenterProducer> currentList = new ArrayList<PresenterProducer>();
                currentList = (ArrayList<PresenterProducer>) ppdao.getAllPresenterProducer(role);
		return currentList;

	}
}
