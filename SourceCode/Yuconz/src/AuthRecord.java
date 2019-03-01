/**
 * stores the details of employee's authorisation attempt
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class AuthRecord {
    private String username;
    private Document requestedDocument;
    private boolean accessGranted;

    /**
     * constructor
     *
     * @param username name of the user who is attempting to be authorised
     * @param requestedDocument document the user wants to access
     * @param accessGranted whether the user was granted access
     */
    public AuthRecord(String username, Document requestedDocument, boolean accessGranted) {
        this.username = username;
        this.requestedDocument = requestedDocument;
        this.accessGranted = accessGranted;
    }
}
