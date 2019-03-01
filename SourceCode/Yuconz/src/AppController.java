/**
 * * controls the actions to everything
 *  *
 *  * @author Alice Jaffray and Kieran D'Arcy
 *  * @version 2019/02/28
 */
public class AppController {
    private User loggedInUser;
    private AccessLevel accessLevel;

    /**
     * constructor
     */
     public AppController(User loggedInUser, AccessLevel accessLevel) {
         this.loggedInUser = loggedInUser;
         this.accessLevel = accessLevel;
     }

    /**
     * logs the user into the system
     *
     * @param username username of the user
     * @param password password of the user
     * @return true if the login was successful and false otherwise
     */
     public boolean login(String username, String password){

         return true;
     }

    /**
     * logs the user out
     *
     * @return true if the user was logged out and false otherwise
     */
    public boolean logout(){
        if(loggedInUser != null){
            System.out.println("Logged Out");
            loggedInUser = null;
            return true;
        }
        else {
            System.out.println("Not logged in");
            return false;
        }
    }

    /**
     * sets the user to have an employee access level
     */
    public void setBasicAccess(){
        accessLevel = AccessLevel.EMPLOYEE;
    }
}