/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainUserTest;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sg.edu.nus.iss.phoenix.authenticate.entity.Role;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.maintainUser.service.MaintainUserService;

/**
 *
 * @author Siva
 */
public class MaintainUserServiceTest {
    User testUser;
     User testUser1;
    
    public MaintainUserServiceTest() {
     testUser=new User(); 
     testUser1=new User(); 
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     testUser.setId("testpass");
     
      testUser1.setId("testfail");

    
    }
    
    @After
    public void tearDown() {
    testUser=null;
    testUser1=null;
    }

     @Test
    public void deleteUserTest(){
        MaintainUserService mus=new MaintainUserService();
        assertTrue(mus.deleteUser(testUser)); 
        assertFalse(mus.deleteUser(testUser1));
         
     }
    
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}