/**
 * subclass of User
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class Director extends User {
    /**
     * constructor
     *
     * @param username
     * @param password
     */
    public Director(String username, String password) {
        super(username, password, "director");
    }
}
