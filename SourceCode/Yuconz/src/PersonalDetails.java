import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * subclss of Document
 * stores the information needed for a personal details record
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/16
 */
public class PersonalDetails extends Document{
    private String forename;
    private String surname;
    private Date dob;
    private String mobileNo;
    private String emergPhoNo;
    private String nextOfKin;
    private String telephoneNo;
    private String emergContact;
    private Address address;

    /**
     * constructor
     *
     * @param creator username of the creator of the document
     * @param forename first name of the employee the record is about
     * @param surname last name of the employee
     * @param dob date of birth of the employee
     * @param mobileNo mobile phone no. of the employee
     * @param emergPhoNo phone no. of the emergency contact for the employee
     * @param nextOfKin next of kin of the employee
     * @param telephoneNo home no. of the employee
     * @param emergContact name of the employee's emergency contact
     * @param address address of the employee
     */
    public PersonalDetails(String creator, String forename, String surname, String dob, String mobileNo,
                           String emergPhoNo, String nextOfKin, String telephoneNo, String emergContact,
                           Address address) {
        super(creator);
        this.forename = forename;
        this.surname = surname;
        try {
        this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
        } catch (Exception e) {e.printStackTrace();}
        this.mobileNo = mobileNo;
        this.emergPhoNo = emergPhoNo;
        this.nextOfKin = nextOfKin;
        this.telephoneNo = telephoneNo;
        this.emergContact = emergContact;
        this.address = address;
    }
}
