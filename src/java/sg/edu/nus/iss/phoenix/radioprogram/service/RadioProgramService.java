package sg.edu.nus.iss.phoenix.radioprogram.service;

import java.sql.SQLException;
import java.util.ArrayList;

import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Milan
 */
public class RadioProgramService {
	DAOFactoryImpl factory;
	RadioProgramDAO rpdao;

    /**
     *
     */
    public RadioProgramService() {
		super();
		// TODO Auto-generated constructor stub
		factory = new DAOFactoryImpl();
		rpdao = factory.getRadioProgramDAO();
	}

    /** searchPrograms-method. This service method searches for a list of
     * matching radio programs by name from the database.
     *
     * @param rpso
     * @return
     */
    public ArrayList<RadioProgram> searchPrograms(RadioProgram rpso) {
		ArrayList<RadioProgram> list = new ArrayList<RadioProgram>();
		try {
			list = (ArrayList<RadioProgram>) rpdao.searchMatching(rpso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

    /**findRPByCriteria. This service method searches for a list of
     * matching radio programs by criteria from the database.
     *
     * @param rp
     * @return 
     */
    public ArrayList<RadioProgram> findRPByCriteria(RadioProgram rp) {
		ArrayList<RadioProgram> currentList = new ArrayList<RadioProgram>();

		try {
			currentList = (ArrayList<RadioProgram>) rpdao.searchMatching(rp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return currentList;

	}

    /**findRP-method. This service method returns a radio program when provided
     * its name as parameter.
     *
     * @param rpName
     * @return
     */
    public RadioProgram findRP(String rpName) {
		RadioProgram currentrp = new RadioProgram();
		currentrp.setName(rpName);
		try {
			currentrp = ((ArrayList<RadioProgram>) rpdao
					.searchMatching(currentrp)).get(0);
			return currentrp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentrp;

	}

    /**findAllR-method. This service method returns all the radio programs in
     * the database.
     *
     * @return
     */
    public ArrayList<RadioProgram> findAllRP() {
		ArrayList<RadioProgram> currentList = new ArrayList<RadioProgram>();
		try {
			currentList = (ArrayList<RadioProgram>) rpdao.loadAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentList;

	}

    /**insertRP-method. This service method creates a radio program in the database
     *
     * @param rp
     */
    public void insertRP(RadioProgram rp) {
		try {
			rpdao.create(rp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**updateRP-method. This service method updates the existing radio program
     * in the database.
     *
     * @param rp
     */
    public void updateRP(RadioProgram rp) {
		
			try {
				rpdao.save(rp);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

    /**deleteRP-method. This service method deletes an existing radio program.
     *
     * @param rp
     */
    public void deleteRP(RadioProgram rp) {

			try {
				rpdao.delete(rp);
		} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}