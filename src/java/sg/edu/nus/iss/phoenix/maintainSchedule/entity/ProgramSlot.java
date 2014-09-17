/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainSchedule.entity;

import java.util.Date;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Milan
 */
public class ProgramSlot {
    
    private Integer duration;
    private Integer id;
    private Date dateOfProgram;
    private Date startTime;
    private RadioProgram radioProgram;
    private User presenter;
    private User producer;

    public ProgramSlot(Integer duration, Date dateOfProgram, Date startTime, RadioProgram radioProgram, User presenter, User producer) {
        this.duration = duration;
        this.dateOfProgram = dateOfProgram;
        this.startTime = startTime;
        this.radioProgram = radioProgram;
        this.presenter = presenter;
        this.producer = producer;
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @return the dateOfProgram
     */
    public Date getDateOfProgram() {
        return dateOfProgram;
    }

    /**
     * @param dateOfProgram the dateOfProgram to set
     */
    public void setDateOfProgram(Date dateOfProgram) {
        this.dateOfProgram = dateOfProgram;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the radioProgram
     */
    public RadioProgram getRadioProgram() {
        return radioProgram;
    }

    /**
     * @param radioProgram the radioProgram to set
     */
    public void setRadioProgram(RadioProgram radioProgram) {
        this.radioProgram = radioProgram;
    }

    /**
     * @return the presenter
     */
    public User getPresenter() {
        return presenter;
    }

    /**
     * @param presenter the presenter to set
     */
    public void setPresenter(User presenter) {
        this.presenter = presenter;
    }

    /**
     * @return the producer
     */
    public User getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(User producer) {
        this.producer = producer;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    
    
    
}
