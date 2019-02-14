/**
 * the class is the superclass for all users
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12
 */
public class User {
    private String username;
    private String password;

    /**
     * constructor
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
