/**
 * the class is the superclass for all users
 * Stores the details of a user
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class User {
    private String username;
    private AccessLevel accessLevel;
    private String department;
    private String manager;

    /**
     * constructor
     * @param username
     * @param department
     * @param accessLevel
     */
    public User(String username, String department, AccessLevel accessLevel, String manager) {
        this.username = username;
        this.department = department;
        this.accessLevel = accessLevel;
        this.manager = manager;
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
     * gets the access level of the user
     *
     * @return the access level of the user
     */
    public AccessLevel getAccessLevel(){
        return accessLevel;
    }

    /**
     * gets user's department.
     * @return the user's department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * gets the manager of the user.
     * @return manager.
     */
    public String getManager() {
        return manager;
    }
}
