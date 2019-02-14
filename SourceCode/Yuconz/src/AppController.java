import java.util.Scanner;

/**
 * controls the actions to everything
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12v2
 */
public class AppController {
    private Scanner input;
    private String name;
    private String password;
    private AuthServer authServer;
    private boolean loggedIn;
    private String option;
    private User currentUser;

    /**
     * constructor
     */
    public AppController(AuthServer a) {
        authServer = a;
        input = new Scanner(System.in);
        name = "";
        password = "";
        loggedIn = false;
        option = "";
    }

    /**
     * runs the app
     */
    public void runController() {
        while (!loggedIn) {
            System.out.print("\nPlease enter your username: ");
            name = input.next().toLowerCase();
            System.out.print("Please enter your password: ");
            password = input.next().toLowerCase();
            loggedIn = login(name, password);
        }
        while (loggedIn) {
            System.out.println("\nPlease choose an option from the menu");
            System.out.println("1. Logout");
            System.out.println("2. Add Authentication details");
            System.out.println("3. Remove Authentication details");
            System.out.println("4. View login records");

            option = input.next();
            switch (option) {
                case "1":
                    logout();
                    runController();
                    break;
                case "2":
                    System.out.print("Enter type: ");
                    String type = input.next().toLowerCase();
                    System.out.print("Enter name: ");
                    name = input.next().toLowerCase();
                    System.out.print("Enter password: ");
                    password = input.next().toLowerCase();
                    authServer.addDetails(type, name, password);
                    break;
                case "3":
                    System.out.print("Enter name: ");
                    name = input.next();
                    System.out.print("Enter password: ");
                    password = input.next();
                    authServer.removeDetails(name, password);
                    break;
                case "4":
                    if (currentUser instanceof HREmployee) {
                        for (LoginRecord records : authServer.getLoginRecords()) {
                            System.out.println(records.getDetails());
                        }
                    } else {
                        //add record of credentials
                        System.out.println("Access denied");
                        break;
                    }

                case "5":
                    break;
            }
        }
    }

    /**
     * logs the user into the system
     *
     * @return true if the login was successful
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

    public boolean getLoggedIn() {
        return loggedIn;
    }
}

