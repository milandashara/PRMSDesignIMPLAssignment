/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainSchedule.delegate;

import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.service.ScheduleService;

/**
 *
 * @author Milan
 */
public class ScheduleDelegate {
    ScheduleService service;
    	public ScheduleDelegate() {
		super();
		service = new ScheduleService();
	}
    	public boolean deleteProgramSlot(ProgramSlot programSlot) {
            
		return service.deleteProgramSlot(programSlot);
	}
}
