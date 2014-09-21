/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao;

import java.sql.SQLException;
import java.util.List;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.entity.PresenterProducer;

/**
 *
 * @author sakthi
 */
public interface ReviewSelectPresenterProducerDAO {
    
    public abstract PresenterProducer createValueObject();
    
    public abstract List<PresenterProducer> getAllPresenterProducer(String role) throws SQLException;
    
}
