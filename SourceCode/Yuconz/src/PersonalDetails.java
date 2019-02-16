import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
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
     * @param creator employee who created the document
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
