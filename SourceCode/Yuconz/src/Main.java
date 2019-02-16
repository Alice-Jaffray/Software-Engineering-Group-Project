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
    public static void main(String[] args) {
        AuthServer authServer = new AuthServer();
        HRDatabase hrDatabase = new HRDatabase();
        authServer.addDetails("hremployee", "kieran", "password");
        authServer.addDetails("employee", "conor", "password");
        authServer.addDetails("employee", "alice", "password");
        AppController appController = new AppController(authServer, hrDatabase);
        appController.runController();
    }
}
