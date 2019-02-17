/**
 * stores the user details of a director
 * subclass of User
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class Director extends User {
    /**
     * constructor
     *
     * @param username username of the director
     * @param password password of the director
     */
    public Director(String username, String password) {
        super(username, password, "director");
    }
}
