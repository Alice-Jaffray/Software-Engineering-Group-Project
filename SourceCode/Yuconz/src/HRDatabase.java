import java.util.ArrayList;
import java.util.HashMap;
/**
 * stores all the records of the employees
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class HRDatabase {
    private ArrayList<AuthRecord> authRecords;
    private ArrayList<Document> documents;
    private HashMap<String, User> users;
    private Document document;
    private AuthRecord authRecord;
    private AnnualReview annualReview;

    /**
     * constructor
     */
    public HRDatabase() {
        authRecords = new ArrayList<AuthRecord>();
        documents = new ArrayList<Document>();
        users = new HashMap<>();
    }

    /**
     * gets a user from the user array list
     *
     * @return a user from the arraylist
     */
    public User getUser(String username){
        return users.get(username);
    }

    /**
     * allows user to read the personal details record of an employee
     *
     * @param empNo the number of the employee who's record it refers to
     * @param requester the user who has requested to view the record
     * @return personal details record of an employee or null otherwise
     */
    public Document readPersonalDetails(String empNo, User requester){
        if(requester.getAccessLevel().equals("hremployee") || requester.getAccessLevel().equals("director") || document.getStaffID().equals(empNo)){

        }
        return null;
    }

    /**
     * allows a user to create a record of personal details of an employee
     * @param empNo the employee number who the record refers to
     * @param requester the user who is requesting to create a personal details record
     * @return true if a new record of personal details is created and false otherwise
     */
    public boolean createPersonalDetails(String empNo, User requester){
        if(requester.getAccessLevel().equals("hremployee")){
            document = new PersonalDetails(empNo, null, null, null, null,
                    null, null, null);
            documents.add(document);
            authRecord = new AuthRecord(requester.getUsername(), document, true);
            authRecords.add(authRecord);
            return true;
        }
        else {
            authRecord = new AuthRecord(requester.getUsername(), null, false);
            authRecords.add(authRecord);
            return false;
        }
    }

    /**
     * allows a user to edit a personal details record
     *
     * @param empNo the number of the employee the record is about
     * @param field the field of the record the user wants to change
     * @param newVal the new value of the field
     * @param requester the user who is requesting to change the record
     */
    public void amendPersonalDetails(String empNo, String field, String newVal, User requester){
        if(requester.getAccessLevel().equals("hremployee")){

        }
    }

    /**
     * allows user to sign a review
     *
     * @param signer the user who signs the record so it's marked as finished
     */
    public void signReview(User signer){

    }

    /**
     * allows a user to create a review record
     *
     * @param empNo  the number of the employee who the record is about
     * @param requester the user requesting to create the record
     * @param reviewer the user who reviewed the employee
     * @return true if the record is created and false otherwise
     */
    public boolean createReviewRecord(String empNo, User requester, User reviewer){
        if(document.getStaffID().equals(empNo) || reviewer.getUsername().equals(reviewer)){
            document = new AnnualReview(empNo, null, null, null,
                    null, null, null);
            documents.add(document);
            authRecord = new AuthRecord(requester.getUsername(), document, true);
            authRecords.add(authRecord);
            return true;
        }
        else {
            authRecord = new AuthRecord(requester.getUsername(), null, false);
            authRecords.add(authRecord);
            return false;
        }
    }

    /**
     * allows a user to edit a review record
     *
     * @param empNo the employee's number who the record is about
     * @param year the year the review was created
     * @param requester the user requesting to amend the record
     */
    public void amendReviewRecord(String empNo, String year, User requester) {
        if (document.getStaffID().equals(empNo) || annualReview.getFirstReviewer().equals   (requester.getUsername()) ||
                annualReview.getSecondReviewer().equals(requester.getUsername())) {
        }
    }

    /**
     * allows a user to read the review record of an employee
     *
     * @param empNo the number of the employee the record refers to
     * @param year the year the review took place
     * @param requester the user who is requesting to read the review
     * @return the document to be read
     */
    public Document readReviewRecord(String empNo, String year, User requester){
       if(requester.getAccessLevel().equals("hremployee")) {

       }
       return null;
    }
}
