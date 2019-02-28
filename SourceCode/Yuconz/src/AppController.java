import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * controls the actions to everything
 *
 * @author Alice Jaffray and Kieran D' and Isaiah Ojo
 * @version 2019/02/16
 */
public class AppController {
    private Scanner input;
    private String name;
    private String password;
    private AuthServer authServer;
    private boolean loggedIn;
    private String option;
    private User currentUser;
    private HRDatabase hrDatabase;

    /**
     * constructor
     *
     * @param a  the authServer used
     * @param db the HR database used
     */
    public AppController(AuthServer a, HRDatabase db) {
        authServer = a;
        input = new Scanner(System.in);
        name = "";
        password = "";
        loggedIn = false;
        option = "";
        hrDatabase = db;
    }

    /**
     * runs the app
     * allows the user to log in
     * gives the user options for functions they can do
     */
    public void runController(String test) throws FileNotFoundException {
        while (!loggedIn) {
            System.out.print("\nPlease enter your username: ");
            name = input.next().toLowerCase();
            System.out.print("Please enter your password: ");
            password = input.next().toLowerCase();
            if (login(name, password) && currentUser.getAuthLevel().equals("hremployee")) {
                System.out.print("\nWould like to log in with Employee privileges(y/n): ");
                if (input.next().equals("y")) {
                    requestPrivileges("employee");
                } else {
                    System.out.println("\nPrivileges unchanged");
                }
            } else {
                System.out.println("\nPrivileges unchanged");
            }
        }

        while (loggedIn) {
            System.out.println("\nPlease choose an option from the menu");
            System.out.println("1. Logout");
            System.out.println("2. Create personal details");
            System.out.println("3. ...");
            System.out.println("4. Change current authorisation level");
            System.out.println("5. ...");
            System.out.println("6. Add a record");
            System.out.println("7. Read current records");
            option = input.next();
            switch (option) {
                case "1":
                    requestPrivileges("reset");
                    break;
                case "2":
                    //first approach to authentication is that we check credentials in the method we called
                    System.out.println(checkSuccess(hrDatabase.createPersonalDetails(currentUser, currentUser.getUsername(), "Kieran", "D'Arcy", "11/01/1999", "01234567891", "09876543212", "Jim", "01992837465", "999", new Address("64", "Zoo Lane", "Canterbury", "Kent", "CT2 7ST"))));
                    break;
                case "3":
                    //second approach is that we check before we call the method
                    if (currentUser.getAuthLevel().equals("...")) {
                        //do something
                    }
                    break;
                case "4":
                    System.out.print("Enter new authorisation level: ");
                    option = input.next();
                    System.out.print("Authorisation level " + checkSuccess(requestPrivileges(option)) + "\n");
                    break;
                case "5":
                    if (currentUser.getAuthLevel().equals("...")) {
                        //do something
                    }
                    break;

                case "6":
                    System.out.println("Please enter the record you would like to add to the file");
                    authServer.writeToFile(test);
                    break;
                case "7":
                    authServer.readFromFile();
                    break;
                default:
                    System.out.println("invalid choice");
                    break;
            }
        }
    }

    /**
     * logs the user into the system
     *
     * @param name     username of the user
     * @param password password of the user
     * @return true if the login was successful and false otherwise
     */
    public boolean login(String name, String password) {
        currentUser = authServer.authenticate(name, password);
        if (currentUser == null) {
            System.out.println("Invalid username/password");
            loggedIn = false;
            return false;
        } else {
            System.out.println("Logged In");
            loggedIn = true;
            return true;
        }
    }

    /**
     * logs the user out
     *
     * @return true if the user was logged out and false otherwise
     */
    public boolean logout() {
        if (loggedIn) {
            System.out.println("Logged Out");
            loggedIn = false;
            currentUser = null;
            return true;
        } else {
            System.out.println("Not logged in");
            loggedIn = false;
            return false;
        }

    }

    /**
    * allows the user to a request a privilege
     * e.g. change their authorisation level
     * @param newAuthLvl The new authentication level for the user.
     * @return true if successful.
     */
    public boolean requestPrivileges(String newAuthLvl) throws FileNotFoundException{
        if (authServer.changePrivileges(currentUser, newAuthLvl.toLowerCase())) {
            logout();
            runController(name);
            return true;
        } else {
            return false;
        }
    }

    /**
     * checks if the user is logged in
     *
     * @return true if the user is logged in and false otherwise
     */
    public boolean getLoggedIn() {
        return loggedIn;
    }

    /**
     * when a user tries to use a function that requires authorisation
     * this method checks if the function was completed successfully
     *
     * @param check the function to check if it was successful.
     * @return A string of success or failure.
     */
    public String checkSuccess(Object check) {
        if (check != null && check.equals(true)) {
            return "Success";
        } else {
            return "Failed";
        }
    }
}

