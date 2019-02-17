/**
 * stores the details of employee's authorisation attempt
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class AuthRecord {
    private String name;
    private Document document;
    private boolean accessGranted;

    /**
     * constructor
     *
     * @param name name of the user who is attempting to be authorised
     * @param document document the user wants to access
     * @param accessGranted whether the user was granted access
     */
    public AuthRecord(String name, Document document, boolean accessGranted) {
        this.name = name;
        this.document = document;
        this.accessGranted = accessGranted;
    }
}
