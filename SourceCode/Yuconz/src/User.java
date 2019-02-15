/**
 * the class is the superclass for all users
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class User {
    private String username;
    private String password;
    private String authLevel;

    /**
     * constructor
     */
    public User(String username, String password, String authLevel) {
        this.username = username;
        this.password = password;
        this.authLevel = authLevel;
    }

    /**
     * gets the username
     * @return username the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * gets the password
     * @return password the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * gets the authorisation level
     * @return authLevel of user
     */
    public String getAuthLevel() { return authLevel;}

    /**
     * set the authorisation level
     * @return authLevel of current user
     */
    public void lowerAuthLevel() {
        if (authLevel.equals("hremployee")){
            authLevel = "employee";
            System.out.println("You now have employee privileges.\nHR Employee access will be reinstated next time you log in.");
        }
    }

    /**
     * gets personal details in an array
     * @return name and password in a neat format
     */
    public String getPersonalDetails() {
        return "Name: " + username + "\nPassword: " + password;
    }
}
