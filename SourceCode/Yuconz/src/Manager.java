/**
 * subclass of Employee
 * Stores the details of a manager
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class Manager extends Employee {

    /**
     * constructor
     * @param username username for the manager.
     * @param manager direct superior.
     * @param department department the user works in.
     */
    public Manager(String username, String manager, String department) {
        super(username, manager, department, AccessLevel.MANAGER);
    }
}
