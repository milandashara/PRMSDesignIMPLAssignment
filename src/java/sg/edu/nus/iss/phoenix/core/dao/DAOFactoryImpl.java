package sg.edu.nus.iss.phoenix.core.dao;

import sg.edu.nus.iss.phoenix.authenticate.dao.RoleDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.UserDao;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.RoleDaoImpl;
import sg.edu.nus.iss.phoenix.authenticate.dao.impl.UserDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.AnnualScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.ProgramSlotDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.WeeklyScheduleDao;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.AnnualScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.ProgramSlotDaoImpl;
import sg.edu.nus.iss.phoenix.maintainSchedule.dao.impl.WeeklyScheduleDaoImpl;
import sg.edu.nus.iss.phoenix.radioprogram.dao.RadioProgramDAO;
import sg.edu.nus.iss.phoenix.radioprogram.dao.impl.RadioProgramDAOImpl;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao.impl.ReviewSelectPresenterProducerDAOImpl;
import sg.edu.nus.iss.phoenix.reviewSelectPresenterProducer.dao.ReviewSelectPresenterProducerDAO;

/**
 *
 * @author Milan
 */
public class DAOFactoryImpl implements DAOFactory {

    private UserDao userDAO = new UserDaoImpl();
    private RoleDao roleDAO = new RoleDaoImpl();
    private RadioProgramDAO rpdao = new RadioProgramDAOImpl();
    private AnnualScheduleDao annualscheduledao = new AnnualScheduleDaoImpl();
    private WeeklyScheduleDao weeklyscheduledao = new WeeklyScheduleDaoImpl();
    private ProgramSlotDao programslotdao = new ProgramSlotDaoImpl();

    /**
     *
     * @return
     */
    @Override
    public UserDao getUserDAO() {
        // TODO Auto-generated method stub
        return userDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public RoleDao getRoleDAO() {
        // TODO Auto-generated method stub
        return roleDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public RadioProgramDAO getRadioProgramDAO() {
        // TODO Auto-generated method stub
        return rpdao;
    }

    /**
     *
     * @return
     */
    @Override
    public AnnualScheduleDao getAnnualScheduleDAO() {
        return annualscheduledao;
    }

    /**
     *
     * @return
     */
    @Override
    public WeeklyScheduleDao getWeeklyScheduleDAO() {
        return weeklyscheduledao;
    }

    /**
     *
     * @return
     */
    @Override
    public ProgramSlotDao getProgramSlotDAO() {
        return programslotdao;
    }

    /**
     *
     * @return
     */
    public ReviewSelectPresenterProducerDAO getReviewSelectPresenterProducerDAO() {
        return new ReviewSelectPresenterProducerDAOImpl();
    }

}