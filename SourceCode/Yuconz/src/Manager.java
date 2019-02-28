/**
 * subclass of Employee
 * Stores the details of a manager
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class Manager extends Employee {
    /**
     * constructor
     *
     * @param username username of the manager
     * @param password password of the manager
     */
    public Manager(String username, String password) {
        super(username, password, "manager");
    }
}
