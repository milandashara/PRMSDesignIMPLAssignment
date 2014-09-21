package sg.edu.nus.iss.phoenix.radioprogram.delegate;

import java.util.ArrayList;

import sg.edu.nus.iss.phoenix.radioprogram.entity.RPSearchObject;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;
import sg.edu.nus.iss.phoenix.radioprogram.service.RadioProgramService;

/**
 *
 * @author Milan
 */
public class RPDelegate {

    /**searchPrograms-method. This method calls a service method to search through
     * the existing database to find all the radio programs with the matching 
     *  name.
     *
     * @param rpso
     * @return
     */
    public ArrayList<RadioProgram> searchPrograms(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		RadioProgramService service = new RadioProgramService();
		return service.searchPrograms(rp);	
	}
	
    /** findRPByCriteria-method.  This method calls a service method to search through
     * the existing database to find all the radio programs with the matching 
     *  description.
     *
     * @param rpso
     * @return
     */
    public ArrayList<RadioProgram> findRPByCriteria(RPSearchObject rpso) {
		RadioProgram rp = new RadioProgram(rpso.getName());
		rp.setDescription(rpso.getDescription());
		RadioProgramService service = new RadioProgramService();
		return service.searchPrograms(rp);	
	}
	
    /** findRP-method. This method calls the service function to retrieve a 
     * radio program by its name.
     *
     * @param rpName
     * @return
     */
    public RadioProgram findRP(String rpName) {
		RadioProgram rp = new RadioProgram(rpName);
		RadioProgramService service = new RadioProgramService();
		return (service.searchPrograms(rp)).get(0);	
		
	}

    /**findAllRP-method. This method calls the service function which returns a 
     * list of all the ratio programs.
     *
     * @return
     */
    public ArrayList<RadioProgram> findAllRP() {
		RadioProgramService service = new RadioProgramService();
		return service.findAllRP();
		
	}
	
    /**insertRP-method. This method calls the service function which inserts a
     * radio program slot into the database.
     *
     * @param rp
     */
    public void insertRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.insertRP(rp);
		
	}

    /**updateRP-method. This method calls the service function which updates a radio
     * program value from an existing value in the database.
     *
     * @param rp
     */
    public void updateRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.updateRP(rp);
		
	}

    /**deleteRP-method. This method calls the service function which deletes a
     * radio program slot from the database.
     *
     * @param rp
     */
    public void deleteRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.deleteRP(rp);
	}
}