/**
 * the class is the superclass for all users
 * Stores the details of a user
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class User {
    private String username;
    private String password;
    private String authLevel;
    private String tmpAuthLvl;

    /**
     * constructor
     *
     * @param username  the username of the user
     * @param password  the password of the user
     * @param authLevel the authorisation level of the user
     */
    public User(String username, String password, String authLevel) {
        this.username = username;
        this.password = password;
        this.authLevel = authLevel;
        tmpAuthLvl = authLevel;
    }

    /**
     * gets the username of the user
     *
     * @return username the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets the password of the user
     *
     * @return password the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * gets the authorisation level of the user
     *
     * @return authLevel of user of the user
     */
    public String getAuthLevel() {
        return authLevel;
    }

    /**
     * sets the authorisation level of the user
     * prints out the new authorisation level
     *
     * @param lvl new wanted authorisation level of user
     */
    public boolean changeAuthLevel(String lvl) {
        if(lvl.equals("employee") || lvl.equals("hremployee") || lvl.equals("director") || lvl.equals("manager")) {
            authLevel = lvl;
            System.out.println("You now have " + lvl + " privileges.\n" + tmpAuthLvl + " access will be reinstated next time you log in.");
            return true;
        } else if(lvl.equals("reset")) {
            authLevel = tmpAuthLvl;
            System.out.println("Your Authorisation level has been returned to normal");
            return true;
        } else {return false;}
    }

    /**
     * gets personal details of a user
     * returns the details in the form of an array
     *
     * @return name and password of user in a neat format
     */
    public String getPersonalDetails() {
        return "Name: " + username + "\nPassword: " + password;
    }
}
