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
    private String emergPhoNo;
    private String telephoneNo;
    private String emergContact;

    /**
     * constructor
     *
     * @param creator username of the creator of the document
     * @param forename first name of the employee the record is about
     * @param surname last name of the employee
     * @param dob date of birth of the employee
     * @param mobileNo mobile phone no. of the employee
     * @param emergPhoNo phone no. of the emergency contact for the employee
     * @param telephoneNo home no. of the employee
     * @param emergContact name of the employee's emergency contact
     */
    public PersonalDetails(String creator, String forename, String surname, String dob, String mobileNo,
                           String emergPhoNo, String telephoneNo, String emergContact) {
        super(creator);
        this.forename = forename;
        this.surname = surname;
        try {
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (Exception e) {e.printStackTrace();}
        this.mobileNo = mobileNo;
        this.emergPhoNo = emergPhoNo;
        this.telephoneNo = telephoneNo;
        this.emergContact = emergContact;
    }
}
