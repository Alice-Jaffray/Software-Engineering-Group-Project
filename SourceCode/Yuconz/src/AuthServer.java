import java.util.ArrayList;
import java.util.HashMap;
/**
 * stores when a successful login takes place
 * stores the correct user login details
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12
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
    }

    /**
     * authenticates the user for login purposes
     * @param name username of user
     * @param password password of user
     * @return true if the user is verified
     */
    public boolean authenticate(String name, String password) {
        if(loginDetails.containsKey(name)){
            try {
                if (loginDetails.get(name).equals(password)) {
                    loginRecords.add(new LoginRecord(name));
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * adds authentication details to the server
     * @param name username of user
     * @param password password of user
     */
    public void addDetails(String name, String password) {
        //for testing
        loginDetails.put(name, password);
    }

    /**
     * removes details from auth server
     * @param name username of te user
     * @param password password of the user
     */
    public void removeDetails(String name, String password){
        loginDetails.remove(name, password);
    }

    public ArrayList<LoginRecord> getLoginRecords() {
        return loginRecords;
    }
}

