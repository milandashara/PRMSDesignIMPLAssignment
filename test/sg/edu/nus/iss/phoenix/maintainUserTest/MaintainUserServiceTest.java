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

    MaintainUserService mus;

    User testUser1;
    User testUser2;
    Role role1;
    Role role2;
    ArrayList<Role> roles;

    public MaintainUserServiceTest() {
        mus = new MaintainUserService();
        testUser1 = new User();
        testUser2 = new User();
        role1 = new Role();
        role2 = new Role();
        roles = new ArrayList<>();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //Role
        role1.setAll("admin", "system administrator");
        role2.setAll("manager", "station manager");
        roles.add(role1);
        roles.add(role2);

        //TestUser1
        testUser1.setId("harry");
        testUser1.setName("harry, the boy");
        testUser1.setPassword("harry");
        testUser1.setRoles(roles);

        //TestUser1
        testUser2.setId("sherlock");
        testUser2.setName("Sherlock Holmes");
        testUser2.setPassword("sherlock");
        testUser2.setRoles(roles);
    }

    @Test
    public void createUserTest() {
        assertTrue(mus.createUser(testUser1));
    }

    @Test
    public void updateUserTest() {
        testUser1.setName("Harry Potter");
        assertTrue(mus.updateUser(testUser1));
    }
    
    @Test
    public void searchMatching() {
        String uid = "harry";
        String newId = mus.searchMatching(uid).getId();
        assertEquals(testUser1.getId(), newId);
    }

    @Test
    public void deleteUserTest() {
        assertTrue(mus.deleteUser(testUser1));
        assertFalse(mus.deleteUser(testUser2));

    }    

    @After
    public void tearDown() {
        roles = null;
        role1 = null;
        role2 = null;
        testUser1 = null;
        testUser2 = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
