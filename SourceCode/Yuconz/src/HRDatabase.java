import java.util.ArrayList;

/**
 * stores all the records of the employees
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
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
     * allows a user to edit a review record
     *
     * @param empNo the employee's number who the record is about
     * @param year the year the review was created
     * @param requester the user requesting to amend the record
     */
    public void amendReviewRecord(String empNo, String year, User requester){

    }

    /**
     * allows a user to create a review record
     *
     * @param empNo  the number of the employee who the record is about
     * @param requester the user requesting to create the record
     * @param reviewer the user who reviewed the employee
     */
    public void createReviewRecord(String empNo, User requester, User reviewer){

    }

    /**
     * allows user to read the personal details record of an employee
     *
     * @param empNo the number of the employee who's record it refers to
     * @param requester the user who has requested to view the record
     */
    public void readPersonalDetails(String empNo, User requester){

    }

    /**
     * allows a user to create a record of personal details of an employee
     * @param empNo the employee number who the record refers to
     * @param requester the user who is requesting to create a personal details record
     */
    public void createPersonalDetails(String empNo, User requester){

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

    }

    /**
     * allows a user to read the review record of an employee
     *
     * @param empNo the number of the employee the record refers to
     * @param year the year the review took place
     * @param requester the user who is requesting to read the review
     */
    public void readReviewRecord(String empNo, String year, User requester){

    }

    /**
     * allows user to sign a review
     */
    public void signReview(){

    }

    public User getUser(String str) {
        return new Employee("AAA000", "password");
    }
}
