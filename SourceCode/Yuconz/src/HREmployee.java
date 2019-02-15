/**
 * subclass of Employee
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class HREmployee extends Employee {
    /**
     * constructor
     *
     * @param username
     * @param password
     */
    public HREmployee(String username, String password) {
        super(username, password, "hremployee");
    }
}
