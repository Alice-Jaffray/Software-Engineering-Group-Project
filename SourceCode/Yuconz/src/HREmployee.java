/**
 * subclass of Employee
 * stores the details of a HR employee
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class HREmployee extends Employee {
    /**
     * constructor
     *
     * @param username
     * @param password
     */
    public HREmployee(String username, String password) {
        super(username, password, AccessLevel.HREMPLOYEE);
    }
}
