/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milan
 */
public class WeeklySchedule {

    private Date startDate;
    private String assignedBy;
    private List<ProgramSlot> programSlotList = new ArrayList<ProgramSlot>();

    public WeeklySchedule(Date startDate, String assignedBy) {
        this.startDate = startDate;
        this.assignedBy = assignedBy;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the assignedBy
     */
    public String getAssignedBy() {
        return assignedBy;
    }

    /**
     * @param assignedBy the assignedBy to set
     */
    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    /**
     * @return the programSlotList
     */
    public List<ProgramSlot> getProgramSlotList() {
        return programSlotList;
    }

    /**
     * @param programSlotList the programSlotList to set
     */
    public void setProgramSlotList(List<ProgramSlot> programSlotList) {
        this.programSlotList = programSlotList;
    }

}
