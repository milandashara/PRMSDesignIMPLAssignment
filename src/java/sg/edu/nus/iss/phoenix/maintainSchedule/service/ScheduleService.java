/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.maintainSchedule.service;

import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.dao.DAOFactoryImpl;
import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.WeeklySchedule;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.delegate.RPDelegate;
import sg.edu.nus.iss.phoenix.radioprogram.entity.RadioProgram;

/**
 *
 * @author Milan,like
 */
public class ScheduleService {

    DAOFactoryImpl factory;
    AnnualScheduleDao annualScheduleDao;
    ProgramSlotDao programSlotDao;
    WeeklyScheduleDao weeklyScheduleDao;
    RadioProgramDAO radioProgramDao;
    UserDao userDao;

    /**
     *
     */
    public ScheduleService() {
        super();
        // TODO Auto-generated constructor stub
        factory = new DAOFactoryImpl();
        annualScheduleDao = factory.getAnnualScheduleDAO();
        programSlotDao = factory.getProgramSlotDAO();
        weeklyScheduleDao = factory.getWeeklyScheduleDAO();
        radioProgramDao = factory.getRadioProgramDAO();
        userDao = factory.getUserDAO();
    }

    /**getAllAnnualSchedulelist-method. This service method loads all the annual
     * schedule objects from the database.
     *
     * @return
     */
    public List<AnnualSchedule> getAllAnnualSchedulelist() {
        try {
            return annualScheduleDao.loadAll();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<AnnualSchedule>();
    }

    /**getAllWeeklySchedulelist-method. This service method loads all the weekly
     * schedule objects when the year is passed as argument.
     *
     * @param year
     * @return
     */
    public List<WeeklySchedule> getAllWeeklySchedulelist(Integer year) {
        try {

            return weeklyScheduleDao.getAllWeeklySchedule(year);

        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<WeeklySchedule>();
    }

    /**deleteProgramSlot-method. This service method is responsible for the
     * deletion of the program slot from the database.
     *
     * @param programSlot
     * @return
     */
    public boolean deleteProgramSlot(ProgramSlot programSlot) {

        try {
            programSlotDao.delete(programSlot);
        } catch (NotFoundException | SQLException e) {
            return false;
        }
        return true;
    }

    private void getObject(Integer year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**insertScheduleProgramSlot-method. This service method inserts the program
     * slot into the database.
     *
     * @param ps
     */
    public void insertScheduleProgramSlot(ProgramSlot ps) {
        try {
            programSlotDao.create(ps);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**updateScheduleProgramSlot-method. This service method updates the program
     * slot details in the database.
     *
     * @param ps
     */
    public void updateScheduleProgramSlot(ProgramSlot ps) {

        try {
            programSlotDao.save(ps);
        } catch (NotFoundException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**getAllRadioProgram-method. This service method returns a list of all the
     * radio program slots.
     *
     * @return
     */
    public List<RadioProgram> getAllRadioProgram() {
        return radioProgramDao.getAllRadioProgram();
    }

    /**findUser-method. This service method returns a user object based on the
     * id passed as argument.
     *
     * @param user
     * @return
     */
    public User findUser(String user) {
        try {
            return userDao.getObject(user);
        } catch (NotFoundException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**validate-method. This service method validates the rules such as empty and
     * null constraints.
     *
     * @param hr
     * @param mt
     * @param startTimeHr
     * @param startTimetMt
     * @param dateOfProgramStr
     * @param programName
     * @param presenterStr
     * @param producerStr
     * @param week
     * @return
     */
    public String validate(String hr, String mt, String startTimeHr, String startTimetMt, String dateOfProgramStr, String programName, String presenterStr, String producerStr,String week) {

        Integer hrs = 0;
        Integer mts = 0;
        Date dateOfProgram = null;
        Integer startTimeHrs = 0;
        Integer startTimeMts = 0;
        Time duration = null;
        Time startTime = null;

        if(week==null)
        {
            return "week cannot be empty";
        }
        
        if (programName == null || programName.equals("")) {
            return "Program Name cannot be null";

        }
        if (presenterStr == null || presenterStr.equals("")) {
            return "presenter cannot be null";

        }
        if (producerStr == null || producerStr.equals("")) {
            return "producer cannot be null";

        }

        try {
            hrs = Integer.parseInt(hr);
            mts = Integer.parseInt(mt);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            dateOfProgram = sdf.parse(dateOfProgramStr);
            startTimeHrs = Integer.parseInt(startTimeHr);
            startTimeMts = Integer.parseInt(startTimetMt);

            duration = getTime(hrs, mts);
            startTime = getTime(startTimeHrs, startTimeMts);

        } catch (Exception e) {
            e.printStackTrace();
            return "invalid  format";

        }

        RPDelegate rPDelegate = new RPDelegate();
        RadioProgram radioProgram = rPDelegate.findRP(programName);

        User presenter = findUser(presenterStr);
        User producer = findUser(producerStr);

        if (radioProgram == null || presenter == null || producer == null) {
            return "Program name / presenter / producer not found";
        }

        return "success";
    }

    /**getTime-method. This service method returns a time object when a hour and
     * minute values are passed as arguments.
     *
     * @param hr
     * @param mt
     * @return
     */
    public Time getTime(int hr, int mt) {

        java.util.Date date = new Date();
        date.setHours(hr);
        date.setMinutes(mt);
        date.setSeconds(0);
        return new Time(date.getTime());
    }

    /**createProgramSlotObject-method. This method constructs a program slot object
     * when the parameters are passed.
     *
     * @param hr
     * @param mt
     * @param startTimeHr
     * @param startTimetMt
     * @param dateOfProgramStr
     * @param programName
     * @param presenterStr
     * @param producerStr
     * @return
     */
    public ProgramSlot createProgramSlotObject(String hr, String mt, String startTimeHr, String startTimetMt, String dateOfProgramStr, String programName, String presenterStr, String producerStr) {

        Integer hrs = 0;
        Integer mts = 0;
        Date dateOfProgram = null;
        Integer startTimeHrs = 0;
        Integer startTimeMts = 0;
        Time duration = null;
        Time startTime = null;

        try {
            hrs = Integer.parseInt(hr);
            mts = Integer.parseInt(mt);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            dateOfProgram = sdf.parse(dateOfProgramStr);
            startTimeHrs = Integer.parseInt(startTimeHr);
            startTimeMts = Integer.parseInt(startTimetMt);
            startTimeMts--;
            mts--;

            duration = getTime(hrs, mts);
            startTime = getTime(startTimeHrs, startTimeMts);

        } catch (Exception e) {
        }

        RPDelegate rPDelegate = new RPDelegate();
        RadioProgram radioProgram = rPDelegate.findRP(programName);

        User presenter = findUser(presenterStr);
        User producer = findUser(producerStr);

        return new ProgramSlot(duration, dateOfProgram, startTime, radioProgram, presenter, producer);

    }

    /**checkTimeSlotConstraint-method. This service method checks for the 
     * business rule constraints on the scheduled program slot.
     *
     * @param programSlot
     * @param week
     * @return
     */
    public String checkTimeSlotConstraint(ProgramSlot programSlot, String week) {

        try {
            if (programSlot.getDuration().getMinutes() < 29) {
                return "duration should not be less than 30 minutes";
            }
            if ((programSlot.getDuration().getMinutes()+1) % 30 != 0) {
                return "duration should  be multiple of 30";
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            Date weekDate = dateFormat.parse(week);
            
           int days= getDiffInDays(programSlot.getDateOfProgram(), weekDate);
           if(days >7)
           {
               return "program slot cannot span over two weeks";
           }
           
           if(programSlotDao.checkOverlappingTimeSlot(programSlot.getDateOfProgram(), programSlot.getStartTime()))
           {
               return "time slot overlaps";
           }
           
           if(programSlot.getDateOfProgram().before(new Date()))
           {
               return "schedule cannot be created for past date";
           }
            
        } catch (ParseException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        return "success";
    }
    
    int getDiffInDays(Date d1,Date d2)
    {
        return  (int)( (d1.getTime() - d2.getTime()) 
                 / (1000 * 60 * 60 * 24) );
    }

    /**createSchedule-method. This service method inserts a program slot into 
     * the database.
     *
     * @param programSlot
     */
    public void createSchedule(ProgramSlot programSlot) {
        try {
            programSlotDao.create(programSlot);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**findProgramSlot-method. This service method returns a program slot object
     * based on its id.
     *
     * @param programSlotId
     * @return
     */
    public ProgramSlot findProgramSlot(Integer programSlotId) {
        try {
            return programSlotDao.getObject(programSlotId);
        } catch (NotFoundException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
