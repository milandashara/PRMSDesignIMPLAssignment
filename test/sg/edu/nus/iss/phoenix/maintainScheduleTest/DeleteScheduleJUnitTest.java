package sg.edu.nus.iss.phoenix.maintainScheduleTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sg.edu.nus.iss.phoenix.maintainSchedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.maintainSchedule.entity.ProgramSlot;

/**
 *
 * @author like
 */
public class DeleteScheduleJUnitTest {
    
    public DeleteScheduleJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void deleteScheduleTest(){
        ProgramSlot ps = new ProgramSlot();
        ps.setId(3);
        ScheduleDelegate sd = new ScheduleDelegate();
        boolean ret = sd.deleteProgramSlot(ps);
        assertFalse(ret);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
