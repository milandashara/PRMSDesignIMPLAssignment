package sg.edu.nus.iss.phoenix.core.dao;

/**
 *
 * @author Milan
 */
public class DBConstants {
	
	// Data Connection Variables

    /**
     *
     */
    	public static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";

    /**
     *
     */
    public static final String dbUrl = "jdbc:mysql://localhost:3306/phoenix";

    /**
     *
     */
    public static final String dbUserName = "root";

    /**
     *
     */
    public static final String dbPassword = "root";
	 
	//Not yet refactored!!!!!!!!!!!!!!!!!!!
	
	// Table names

    /**
     *
     */
        public static final String usersTableName = "user";

    /**
     *
     */
    public static final String rolesTableName = "role";
   
    
    
    //Users table field names

    /**
     *
     */
        public static final String u_id = "id";

    /**
     *
     */
    public static final String u_name = "name";

    /**
     *
     */
    public static final String u_password = "password";

    /**
     *
     */
    public static final String u_role ="role";
    
    
    //Program Slot table field names

    /**
     *
     */
        public static final String ps_id = "id";

    /**
     *
     */
    public static final String ps_duration = "duration";

    /**
     *
     */
    public static final String ps_dateAndTimeOfProgram = "dateAndTimeOfProgram";

    /**
     *
     */
    public static final String ps_programName ="programName";

    /**
     *
     */
    public static final String ps_presenter ="presenter";

    /**
     *
     */
    public static final String ps_producer ="producer";

    /**
     *
     */
    public static final String ps_dateOfProgram = "dateOfProgram";

    /**
     *
     */
    public static final String ps_startTime = "startTime";
    
    //roles table field names

    /**
     *
     */
        public static final String r_role = "role";

    /**
     *
     */
    public static final String r_access ="accessPrivilege";

    



}