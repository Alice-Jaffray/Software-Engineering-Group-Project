import java.util.ArrayList;

/**
 * stores all the records of the employees
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class HRDatabase {
    private ArrayList<AuthRecord> authRecords;
    private ArrayList<Document> documents;
    private Document document;

    /**
     * constructor
     */
    public HRDatabase() {
        authRecords = new ArrayList<AuthRecord>();
        documents = new ArrayList<Document>();
    }

    /**
     * creates a authorisation record
     *
     * @param name name of person making attempt
     * @param document file that tried to be accessed
     * @param accessGranted permission accepted or declined
     */
    public void addAuthRecord(String name, Document document, boolean accessGranted) {
        authRecords.add(new AuthRecord(name, document, accessGranted));
    }

    /**
     * reads personal details of an employee
     * if the user is a HR employee
     *
     * @param user the user attempting to read the personal details
     * @return personal details of employee or null otherwise
     */
    public Document readPersonalDetails(User user) {
        if (user.getAuthLevel().equals("hremployee")){

        }
        return null;
    }

    /**
     * creates a new record of personal details for an employee
     *
     * @param creator person creating the document
     * @param forename first name of employee
     * @param surname last name of employee
     * @param DOB date of birth for employee
     * @param mobileNo mobile phone no. for employee
     * @param emergencyNo emergency contact no. for employee
     * @param nextOfKin next of kin of an employee
     * @param telephoneNo home telephone number of employee
     * @param emergeContact name of emergency contact for employee
     * @param address home address of employee
     * @return true if a new record of personal details is created and false otherwise
     */
    public boolean createPersonalDetails(User user, String creator, String forename, String surname, String DOB, String mobileNo, String emergencyNo, String nextOfKin, String telephoneNo, String emergeContact, Address address) {
        if (user.getAuthLevel().equals("hremployee")){
            document = new PersonalDetails(creator, forename, surname, DOB, mobileNo, emergencyNo, nextOfKin, telephoneNo, emergeContact, address);
            documents.add(document);
            addAuthRecord(user.getUsername(), document, true);
            return true;
        } else {
            addAuthRecord(user.getUsername(), null, false);
            return false;
        }

    }
}
