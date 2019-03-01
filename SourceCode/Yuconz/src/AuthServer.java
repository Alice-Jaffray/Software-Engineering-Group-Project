import java.util.ArrayList;
/**
 * stores when a successful login takes place
 * mock of server that holds login information.
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class AuthServer {
    private ArrayList<User> loginDetails;
    private ArrayList<LoginRecord> loginRecords;

    /**
     * constructor
     */
    public AuthServer() {
        loginDetails = new ArrayList<>();
        loginRecords = new ArrayList<>();
    }

    /**
     * authenticates the user for login purposes
     * logs the details of the login attempt
     *
     * @param name username of user
     * @param password password of user
     * @return the user who is trying to be authenticated or null if attempt failed
     */
    public User authenticate(String name, String password) {
        for(User users : loginDetails) {
            if(users.getUsername().equals(name) && users.getPassword().equals(password)) {
                loginRecords.add(new LoginRecord(name));
                return users;
            }
        }
        return null;
    }

}

