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

        AuthServer authServer = new AuthServer("Databases/LoginRecords.csv", "jdbc:sqlite:Databases/Yuconz.db");
        HRDatabase hrDatabase = new HRDatabase();


        AppController appController = new AppController(hrDatabase, authServer);
        appController.runController();
        }
    }
