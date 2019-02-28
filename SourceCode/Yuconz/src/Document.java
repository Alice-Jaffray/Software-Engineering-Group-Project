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
     * @param creator the creator of the document
     */
    public Document(String creator) {
        staffID = creator;
    }
}
