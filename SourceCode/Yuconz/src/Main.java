import java.io.FileNotFoundException;

/**
 * creates all needed objects to start the program
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class Main {
    /**
     * Starts the app
     */
    public static void main(String[] args) throws FileNotFoundException {

        AuthServer authServer = new AuthServer();
        HRDatabase hrDatabase = new HRDatabase();

        AppController appController = new AppController(authServer, hrDatabase);
        appController.runController();
        }
    }
