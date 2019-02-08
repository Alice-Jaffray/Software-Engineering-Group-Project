import java.util.ArrayList;
import java.util.HashMap;
/**
 * stores when a successful login takes place
 * stores the correct user login details
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 1.0 2019/02/05
 */
public class AuthServer {
    private HashMap<String, String> loginDetails;
    private ArrayList<LoginRecord> loginRecords;
    /**
     * constructor
     */
    public AuthServer() {
        loginDetails = new HashMap<>();
        loginRecords = new ArrayList<>();
        //for testing
        loginDetails.put("abc123","yayeet");
    }

    /**
     * allows new records to be added to the database
     */
    private void addNewRecord(String username, String password) {
        if(!loginDetails.containsKey(username))
            loginDetails.put(username, password);
        else
            System.out.println("User already exists in database");
    }

    /**
     * authenticates the user for login purposes
     * @param name username of user
     * @param password password of user
     * @return true if the user is verified
     */
    public boolean authenticate(String name, String password) {

        if(loginDetails.containsKey(name))
        try {
            if (loginDetails.get(name).equals(password))
                loginRecords.add(new LoginRecord(name));
                return true;
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

