/**
 * subclass of user and superclass of HREmployee and Manager
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class Employee extends User {
    /**
     * constructor
     *
     * @param username
     * @param password
     */
    public Employee(String username, String password) {
        super(username, password, "employee");
    }
    public Employee(String username, String password, String authlevel) {super(username, password, authlevel);}
}
