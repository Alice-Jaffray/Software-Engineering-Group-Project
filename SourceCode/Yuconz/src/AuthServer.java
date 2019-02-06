import java.util.ArrayList;
import java.util.HashMap;
/**
 * stores when a successful login takes place
 * stores the correct user login details
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 1.0 2019/02/05
 */
public class AuthServer {
    public HashMap<String, String> loginDetails;
    public ArrayList<LoginRecord> loginRecords;
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

