import java.util.ArrayList;
import java.util.HashMap;
/**
 * stores when a successful login takes place
 * stores the correct user login details
 */
public class AuthServer {
    public HashMap<String, String> loginDetails;
    /**
     * constructor
     */
    public AuthServer() {
        loginDetails = new HashMap<>();
    }

    public boolean authenticate() {

        return true;
    }
}

