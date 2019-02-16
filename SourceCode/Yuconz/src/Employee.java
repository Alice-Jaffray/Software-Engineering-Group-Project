/**
 * subclass of User and superclass of HREmployee and Manager
 * stores the details of an employee
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class Employee extends User {
    /**
     * constructor
     *
     * @param username the username of the employee
     * @param password the password of the employee
     */
    public Employee(String username, String password) {
        super(username, password, "employee");
    }

    /**
     * second constructor
     *
     * @param username the username of the employee
     * @param password the password of the employee
     * @param authlevel the authorisation level of the employee
     */
    public Employee(String username, String password, String authlevel) {
        super(username, password, authlevel);
    }
}
