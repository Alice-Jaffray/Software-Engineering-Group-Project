/**
 * the class is the superclass for all users
 * Stores the details of a user
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class User {
    private String username;
    private String password;
    private AccessLevel accessLevel;

    /**
     * constructor
     *
     * @param username  the username of the user
     * @param password  the password of the user
     * @param accessLevel the authorisation level of the user
     */
    public User(String username, String password, AccessLevel accessLevel) {
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    /**
     * gets the username of the user
     *
     * @return the username of the user
     */
    public String getUsername(){
        return username;
    }

    /**
     * gets the password of the user
     *
     * @return the password of the user
     */
    public String getPassword(){
        return password;
    }

    /**
     * gets the access level of the user
     *
     * @return the access level of the user
     */
    public AccessLevel getAccessLevel(){
        return accessLevel;
    }

}
