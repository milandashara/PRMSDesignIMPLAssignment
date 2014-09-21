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

    /**
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
	
    /**
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
	
    /**
     *
     * @param rpName
     * @return
     */
    public RadioProgram findRP(String rpName) {
		RadioProgram rp = new RadioProgram(rpName);
		RadioProgramService service = new RadioProgramService();
		return (service.searchPrograms(rp)).get(0);	
		
	}

    /**
     *
     * @return
     */
    public ArrayList<RadioProgram> findAllRP() {
		RadioProgramService service = new RadioProgramService();
		return service.findAllRP();
		
	}
	
    /**
     *
     * @param rp
     */
    public void insertRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.insertRP(rp);
		
	}

    /**
     *
     * @param rp
     */
    public void updateRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.updateRP(rp);
		
	}

    /**
     *
     * @param rp
     */
    public void deleteRP(RadioProgram rp) {
		RadioProgramService service = new RadioProgramService();
		service.deleteRP(rp);
	}
}