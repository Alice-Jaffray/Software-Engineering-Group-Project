/**
 * superclass of Personal details and annual review
 * stores the details of a document
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class Document {
    private String staffID;

    /**
     * constructor
     *
     * @param staffID the creator of the document
     */
    public Document(String staffID) {
        this.staffID = staffID;
    }

    /**
     * gets the employee's id
     *
     * @return the employee's id
     */
    public String getStaffID(){
        return staffID;
    }
}
