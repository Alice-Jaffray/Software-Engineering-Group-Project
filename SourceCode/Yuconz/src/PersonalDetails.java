import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * subclss of Document
 * stores the information needed for a personal details record
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class PersonalDetails extends Document{
    private String forename;
    private String surname;
    private Date dob;
    private String mobileNo;
    private String telephoneNo;
    private String emergContact;
    private String emergTel;

    /**
     * constructor
     *
     * @param staffID username of the employee who the document refers to
     * @param forename first name of the employee the record is about
     * @param surname last name of the employee
     * @param dob date of birth of the employee
     * @param mobileNo mobile phone no. of the employee
     * @param telephoneNo phone no. of the emergency contact for the employee
     * @param emergContact home no. of the employee
     * @param emergTel name of the employee's emergency contact
     */
    public PersonalDetails(String staffID, String forename, String surname, String dob, String mobileNo,
                           String telephoneNo, String emergContact, String emergTel) {
        super(staffID);
        this.forename = forename;
        this.surname = surname;
        try {
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (Exception e) {e.printStackTrace();}
        this.mobileNo = mobileNo;
        this.telephoneNo = telephoneNo;
        this.emergContact = emergContact;
        this.emergTel = emergTel;
    }
}
