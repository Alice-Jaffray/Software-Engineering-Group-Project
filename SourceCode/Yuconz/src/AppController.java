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

    /**
     * constructor
     */
     public AppController() {
         scan = new Scanner(System.in);
     }

    /**
     * Calls display methods for the user.
     */
    public void runController() {
         boolean loggedIn = false;
         while(!loggedIn) {
             if(loginPrompt()) {
                 loggedIn = true;
             }
         }

         mainMenu();
     }

    /**
     * Displays the login screen functionality.
     * @return true if valid details were entered.
     */
     private boolean loginPrompt() {
         System.out.println("Welcome to Yuconz Document System. Please Enter Your username:");
         System.out.println();
         System.out.print("Username: ");
         String username = scan.next();
         System.out.println();
         System.out.print("Password: ");
         String password = scan.next();
         if(login(username, password)) {
             System.out.println();
             System.out.println("Logged In");
             loggedInUser = hrDatabase.getUser(username);
             // Higher level users get the option to login as a base level employee.
             if(loggedInUser.getAccessLevel() != AccessLevel.EMPLOYEE) { basicAccessPrompt(); }
             return true;
         } else {
             System.out.println();
             System.out.println("Invalid username or password.");
             return false;
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
             } else if (option.equals("n")) {
                 return;
             } else {
                 System.out.println("That is not a valid option. Please enter either 'y' or 'n' (no quotes).");
             }
         }
     }

     private void mainMenu() {
         System.out.println("Welcome to the Yuconz document system.");
         System.out.println("Please select an option.");
         System.out.println();
         System.out.println("1. ");
     }

    /**
     * logs the user into the system
     *
     * @param username username of the user
     * @param password password of the user
     * @return true if the login was successful and false otherwise
     */
     public boolean login(String username, String password){ //TODO
        return true;
     }

    /**
     * logs the user out
     *
     * @return true if the user was logged out and false otherwise
     */
    public boolean logout(){
        if(loggedInUser != null){
            System.out.println("Logged Out");
            loggedInUser = null;
            return true;
        }
        else {
            System.out.println("Not logged in");
            return false;
        }
    }

    /**
     * sets the user to have an employee access level
     */
    public void setBasicAccess(){
        accessLevel = AccessLevel.EMPLOYEE;
    }
}