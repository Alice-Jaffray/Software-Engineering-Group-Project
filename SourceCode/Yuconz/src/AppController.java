import java.util.Scanner;

/**
 * controls the actions to everything
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/08
 */
public class AppController {
    private Scanner input;
    private String name;
    private String password;
    private AuthServer authServer;
    private boolean loggedIn;
    private String option;

    /**
     * constructor
     */
    public AppController(AuthServer authServer) {
        input = new Scanner(System.in);
        name = "";
        password = "";
        this.authServer = authServer;
        loggedIn = false;
        option = "";
    }

    /**
     * starts the app
     */
    public static void main(String[] args) {
        AppController controller = new AppController(new AuthServer());
        controller.runController();
    }

    /**
     * runs the app
     */
    public void runController() {
        while(loggedIn == false) {
            System.out.println("Please enter your username");
            name = input.next().toLowerCase();
            System.out.println("Please enter your password");
            password = input.next().toLowerCase();
            login(name, password);
        }
        while(loggedIn == true) {
            System.out.println("Please choose an option from the menu");
            System.out.println("1. Logout");

            option = input.next();
            switch(option)
            {
                case "1":
                    logout();
                    runController();
            }
        }
    }

    /**
     * logs the user into the system
     * @return true if the login was successful
     */
    public boolean login(String name, String password) {
        boolean verified = authServer.authenticate(name, password);
        if(!verified) {
            System.out.println("Invalid username/password");
            loggedIn = false;
        }
        else {
            loggedIn = true;
            System.out.println("Logged In");
        }
        return verified;
    }

    /**
     * logs the user out
     */
    public void logout() {
        if(loggedIn){
            loggedIn = false;
            System.out.println("Logged Out");
        }
    }
}

