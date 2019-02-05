import java.util.Scanner;

/**
 * controls the actions to everything
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 1.0 2019/02/05
 */
public class AppController {
    private Scanner input;
    private String name;
    private String password;

    /**
     * constructor
     */
    public AppController() {
        input = new Scanner(System.in);
        name = "";
        password = "";
    }

    /**
     * starts the app
     */
    public static void main(String[] args) {
        AppController controller = new AppController();
        controller.login();
    }

    /**
     * logs the user into the system
     * @return true if the login was successful
     */
    public boolean login() {
        System.out.println("Please enter your username");
        name = input.next().toLowerCase();
        System.out.println("Please enter your password");
        password = input.next().toLowerCase();
        return true;
    }
}

