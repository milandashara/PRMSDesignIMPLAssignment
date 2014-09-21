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
    
   /**
	 * createValueObject-method. This method is used when the Dao class needs to
	 * create new value object instance. The reason why this method exists is
	 * that sometimes the programmer may want to extend also the valueObject and
	 * then this method can be over-rided to return extended valueObject.
     * @return
     */
    public abstract PresenterProducer createValueObject();
    
    /** getAllPresenterProducer-method. This method is used when the dao class needs to 
     * get a list of presenter or producers.
     *
     * @param role
     * @return
     * @throws SQLException
     */
    public abstract List<PresenterProducer> getAllPresenterProducer(String role) throws SQLException;
    
}
