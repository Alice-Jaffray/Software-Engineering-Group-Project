import java.util.Scanner;
/**
 * * controls the actions to everything
 *  *
 *  * @author Alice Jaffray and Kieran D'Arcy
 *  * @version 2019/02/28
 */
public class AppController {
    private Scanner scan;
    private User loggedInUser;
    private AccessLevel accessLevel;
    private HRDatabase hrDatabase;
    private AuthServer authServer;
    private boolean loggedIn;

    /**
     * constructor
     */
    AppController(HRDatabase hr, AuthServer a) {
        scan = new Scanner(System.in);
        hrDatabase = hr;
        authServer = a;
        loggedIn = false;
    }

    /**
     * Calls display methods for the user.
     */
    void runController() {
        while(!loggedIn) {
            loginPrompt();
        }
        baseMainMenu();
        switch(accessLevel) {
            case EMPLOYEE: employeeMainMenu(); break;
            case HREMPLOYEE: hREmployeeMainMenu(); break;
            case DIRECTOR: directorMainMenu(); break;
            default: employeeMainMenu(); break;
        }
    }

    /**
     * Read the logs from the AuthServer.
     */
    private void readLogs() {
        authServer.readFromFile();
    }

    /**
     * Logs the user into the system
     *
     * @param username username of the user
     * @param password password of the user
     * @return true if the login was successful and false otherwise
     */
    boolean login(String username, String password){
        String access = authServer.authenticate(username, password);
        if(access.equals("denied")) {
            loggedIn = false;
            return false;
        } else {
            switch(access) {
                case "employee": accessLevel = AccessLevel.EMPLOYEE; break;
                case "hremployee": accessLevel = AccessLevel.HREMPLOYEE; break;
                case "manager": accessLevel = AccessLevel.MANAGER; break;
                case "director": accessLevel = AccessLevel.DIRECTOR; break;
                default: return false;
            }
            loggedInUser = hrDatabase.getUser(username);
            loggedIn = true;
            System.out.println(accessLevel.toString());
            return true;
        }
    }

    /**
     * logs the user out.
     */
    void logout(){
        System.out.println("Logged Out");
        loggedInUser = null;
        loggedIn = false;
    }

    /**
     * Get the personal details document for a different employee.
     * @param empID The owner of the document
     * @return the document associated with empID.
     */
    PersonalDetails readPersonalDetails(String empID) {
        return hrDatabase.readPersonalDetails(empID, loggedInUser);
    }

    /**
     * Create a new blank document for the employee associated with empID.
     * @param empID the employee the document is for.
     * @return true if successful.
     */
    boolean createPersonalDetails(String empID) {
        return hrDatabase.createPersonalDetails(empID, loggedInUser);
    }

    void amendPersonalDetails(String empID, String field, String newVal) {
        hrDatabase.amendPersonalDetails(empID, field, newVal, loggedInUser);
    }

    /**
     * sets the user to have an employee access level
     */
    void setBasicAccess(){
        accessLevel = AccessLevel.EMPLOYEE;
    }

    /**
     * Getter for access level.
     * @return access level for the logged in user.
     */
    AccessLevel getAccessLevel() {
        return accessLevel;
    }

    /**
     * Getter for logged in user.
     * @return the logged in user.
     */
    User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Getter for if anyone is logged into the system.
     * @return true if there is a user logged in.
     */
    boolean isLoggedIn() {
        return loggedIn;
    }

    // Methods for displaying menus and such. Untestable, so out of the way.

    /**
     * Displays the login screen functionality.
     */
    private void loginPrompt() {
        System.out.println("Welcome to Yuconz Document System. Please enter your username and password:");
        System.out.println();
        System.out.print("Username: ");
        String username = scan.next();
        System.out.println();
        System.out.print("Password: ");
        String password = scan.next();
        if(login(username, password)) {
            System.out.println();
            System.out.println("Logged In");
            // Higher level users get the option to login as a base level employee.
            try {
                if (accessLevel != AccessLevel.EMPLOYEE) {
                    basicAccessPrompt();
                }
            } catch (NullPointerException ex) {
                System.out.println("User not present in HR database, contact system administrator.");
            }
        } else {
            System.out.println();
            System.out.println("Invalid username or password.");
        }
    }

    /**
     * User access menu.
     */
    private void basicAccessPrompt() {
        while (true) {
            System.out.print("Would you like to login with base employee access? (y/n): ");
            String option = scan.next().toLowerCase();
            if (option.equals("y")) {
                setBasicAccess();
                return;
            } else if (option.equals("n")) {
                return;
            } else {
                System.out.println("That is not a valid option. Please enter either 'y' or 'n' (no quotes).");
            }
        }
    }

    private void baseMainMenu() {
        System.out.println("Welcome to the Yuconz document system.");
        System.out.println("Please select an option.");
        System.out.println();

        System.out.println("1. Logout");
        System.out.println("2. Read Own Personal Details");
    }

    private void employeeMainMenu() {
        String option = scan.next();
        switch (option) {
            case "1": logout(); break;
            case "2": readOwnPersonalDetails(); break;
            default: System.out.println("That is not a valid option.");
        }
        runController();
    }

    private void hREmployeeMainMenu() {
        System.out.println("3. Add new login");
        System.out.println("4. Read other personal details.");
        System.out.println("5. Create new personal details");
        System.out.println("6. Amend existing personal details.");

        String option = scan.next();
        switch (option) {
            case "1": logout(); break;
            case "2": readOwnPersonalDetails(); break;
            case "3": addNewLogin(); break;
            case "4": readOtherPersonalDetails(); break;
            case "5": createPersonalDetails(); break;
            case "6": amendPersonalDetails(); break;
            default: System.out.println("That is not a valid option.");
        }
        runController();
    }

    private void directorMainMenu() {
        System.out.println("3. Read other personal details document.");
        String option = scan.next();
        switch (option) {
            case "1": logout(); break;
            case "2": readOwnPersonalDetails(); break;
            case "3": readOtherPersonalDetails(); break;
            default: System.out.println("That is not a valid option.");
        }
        runController();
    }

    private void readOwnPersonalDetails() {
        PersonalDetails p = readPersonalDetails(loggedInUser.getUsername());
        printPersonalDetails(p);
    }

    private void readOtherPersonalDetails() {
        System.out.print("Enter username of document owner:");
        PersonalDetails p = readPersonalDetails(scan.next());
        printPersonalDetails(p);

    }

    private void printPersonalDetails(PersonalDetails p) {
        if(p != null) {
            System.out.println();
            System.out.println(p.getStaffID());
            System.out.println(p.getForename());
            System.out.println(p.getSurname());
            System.out.println(p.getDob());
            System.out.println(p.getMobileNo());
            System.out.println(p.getTelephoneNo());
            System.out.println(p.getEmergContact());
            System.out.println(p.getEmergTel());
        } else {
            System.out.println("No personal details document for that employee was found. Contact HR.");
        }
    }

    private void createPersonalDetails() {
        System.out.print("Enter username of new employee: ");
        boolean success = createPersonalDetails(scan.next());
        System.out.println();
        if (success) {
            System.out.println("Success! Please amend the document to add values.");
        } else {
            System.out.println("Failure, document not created. Document may already exist.");
        }
    }

    private void amendPersonalDetails() {
        System.out.println("Enter username of employee: ");
        String emp = scan.next();
        boolean done = false;
        while(!done){
            System.out.println("Select a field to change: ");
            System.out.println("1. Forename");
            System.out.println("2. Surname");
            System.out.println("3. Date of Birth");
            System.out.println("4. Mobile Number");
            System.out.println("5. Telephone Number");
            System.out.println("6. Emergency Contact Name");
            System.out.println("7. Emergency Telephone Number");
            boolean selected = false;
            while (!selected) {
                String option = scan.next();
                System.out.print("Please enter the new value: ");
                switch (option) {
                    case "1": amendPersonalDetails(emp, "forename", scan.next()); selected = true;  break;
                    case "2": amendPersonalDetails(emp, "surname", scan.next()); selected = true;  break;
                    case "3": amendPersonalDetails(emp, "dob", scan.next()); selected = true;  break;
                    case "4": amendPersonalDetails(emp, "mobileNo", scan.next()); selected = true;  break;
                    case "5": amendPersonalDetails(emp, "telephoneNo", scan.next()); selected = true;  break;
                    case "6": amendPersonalDetails(emp, "emergContact", scan.next()); selected = true; break;
                    case "7": amendPersonalDetails(emp, "emergTel", scan.next()); selected = true; break;
                    default: System.out.println("Please select a valid option.");
                }
                System.out.println("Done? (y/n)");
                option = scan.next();
                boolean finished = false;
                while (!finished) {
                    switch (option) {
                        case "y":
                            finished = true;
                            done = true;
                            break;
                        case "n":
                            finished = true;
                            done = false;
                            break;
                        default: System.out.println("Please select a valid option.");
                    }
                }
            }
        }
        System.out.println("Done!");
    }

    private void addNewLogin() {
        System.out.println("Enter details for new user:");
        System.out.print("Enter Username: ");
        String user = scan.next();
        System.out.println();
        System.out.print("Enter Password: ");
        String pass = scan.next();
        System.out.println();
        System.out.println("Select Access Level: ");
        System.out.println("1. Employee");
        System.out.println("2. HR Employee");
        System.out.println("3. Manager");
        System.out.println("4. Director");
        String access = "";
        boolean selected = false;
        while(!selected) {
            String option = scan.next();
            switch (option) {
                case "1":
                    access = "employee";
                    selected = true;
                    break;
                case "2":
                    access = "hremployee";
                    selected = true;
                    break;
                case "3":
                    access = "manager";
                    selected = true;
                    break;
                case "4":
                    access = "director";
                    selected = true;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
        System.out.println("Select Access Level: ");
        System.out.println("1. Human Resources");
        System.out.println("2. Services Delivery");
        System.out.println("3. Sales and Marketing");
        System.out.println("4. Administration");
        selected = false;
        String department = "";
        while(!selected) {
            String option = scan.next();
            switch (option) {
                case "1":
                    department = "human resources";
                    selected = true;
                    break;
                case "2":
                    department = "services delivery";
                    selected = true;
                    break;
                case "3":
                    department = "sales and marketing";
                    selected = true;
                    break;
                case "4":
                    department = "administration";
                    selected = true;
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }

        if(authServer.insertLogin(user, pass, access) && hrDatabase.addUser(user, department, null, access)) {
            System.out.println(user + " added to database.");
        } else {
            System.out.println(user + " could not be added to database.");
        }
    }
}