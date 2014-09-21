package sg.edu.nus.iss.phoenix.frontcontroller;

/**
 *
 * @author Milan
 */
public class FCUtilities {
	//Get userId from the servlet pathInfo    

    /**
     *
     * @param pathInfo
     * @return
     */
        public static String stripPath(String pathInfo){
        int pos = pathInfo.indexOf("/");
        int len = pathInfo.length();
        String userId = pathInfo.substring(pos+1,len);
        System.out.println("Path: " + userId);
        return userId;
    }
}
