import java.util.ArrayList;
/**
 * stores when a successful login takes place
 * stores the correct user login details
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

    /**
     * adds authentication details to the server
     * @param type job role of user i.e. authentication level
     * @param name username of the user
     * @param password password of the user
     */
    public void addDetails(String type, String name, String password) {
        //for testing
        switch (type.toLowerCase()) {
            case "employee":
                loginDetails.add(new Employee(name, password));
                break;
            case "hremployee":
                loginDetails.add(new HREmployee(name, password));
                break;
            case "manager":
                loginDetails.add(new Manager(name, password));
                break;
            case "director":
                loginDetails.add(new Director(name, password));
                break;
            default:
                System.out.println("Please pick a valid option!");
                break;
        }
    }

    /**
     * removes details from auth server
     * @param name username of te user
     * @param password password of the user
     */
    public void removeDetails(String name, String password){
        for (User users : loginDetails) {
            if(users.getUsername().equals(name) && users.getPassword().equals(password)) {
                loginDetails.remove(users);
                System.out.println("User '" + name + "' as been removed");
                break;
            }
        }
    }

    /**
     * updates the user's authorisation level
     *
     * @param user the user who's authorisation level is being changed
     * @param newAuthLvl the wanted authorisation level
     * @return true is the authorisation level is changed and false otherwise
     */
    public boolean changePrivileges(User user, String newAuthLvl) {
        if (loginDetails.contains(user) && loginDetails.get(loginDetails.indexOf(user)).changeAuthLevel(newAuthLvl)) {
            System.out.println("Privileges lowered to employee, Please re-login!");
            return true;
        } else {
            System.out.println("Failed, can't find user OR insufficient privileges.");
            return false;
        }
    }

    /**
     * get all the login records
     * if the user is a HR employee
     *
     * @param user the user attempting to get the login records
     * @return the login records if the user is a HR employee and null otherwise
     */
    public ArrayList<LoginRecord> getLoginRecords(User user) {
        if (user.getAuthLevel().equals("hremployee")){
            return loginRecords;
        } else {
            return null;
        }
    }

    /**
     * prints the the login records
     * if the user is a HR employee
     * @param user the user attempting to print the login records
     * @return true if the records were printed and false if not
     */
    public boolean printLoginRecords(User user) {
        if (user.getAuthLevel().equals("hremployee")){
            for (LoginRecord records : loginRecords) {
                System.out.println(records.getDetails());
            }
            return true;
        } else {
            return false;
        }
    }
}

