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

    /**
     * constructor
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param authLevel the authorisation level of the user
     */
    public User(String username, String password, String authLevel) {
        this.username = username;
        this.password = password;
        this.authLevel = authLevel;
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
     */
    public void lowerAuthLevel() {
        if (authLevel.equals("hremployee")){
            authLevel = "employee";
            System.out.println("You now have employee privileges.\nHR Employee access will be reinstated next time you log in.");
        }
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
