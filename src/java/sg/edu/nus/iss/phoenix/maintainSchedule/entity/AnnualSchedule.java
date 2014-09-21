/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.entity;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Milan
 */
public class AnnualSchedule {

    private Integer year;

    private String assignedBy;

    private List<WeeklySchedule> weeklyScheduleList=new ArrayList<WeeklySchedule>();
    
    public AnnualSchedule(Integer year, String assignedBy) {
        this.year = year;
        this.assignedBy = assignedBy;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
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
     * @return the weeklyScheduleList
     */
    public List<WeeklySchedule> getWeeklyScheduleList() {
        return weeklyScheduleList;
    }

    /**
     * @param weeklyScheduleList the weeklyScheduleList to set
     */
    public void setWeeklyScheduleList(List<WeeklySchedule> weeklyScheduleList) {
        this.weeklyScheduleList = weeklyScheduleList;
    }

}