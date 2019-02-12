/**
 * creates all needed objects to start the program
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12
 */
public class Main {

    /**
     * Starts the app
     */
    public static void main(String[] args) {
        AuthServer authServer = new AuthServer();
        authServer.addDetails("kieran", "password");
        authServer.addDetails("jim", "word");
        authServer.addDetails("bob", "pass");
        AppController appController = new AppController(authServer);
        appController.runController();
    }
}
