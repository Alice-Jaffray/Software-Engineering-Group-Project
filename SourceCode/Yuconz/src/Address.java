/**
 * stores the details of an employee's address
 * (part of their personal details)
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/15
 */
public class Address {
    private String houseNo;
    private String street;
    private String town;
    private String county;
    private String postcode;

    /**
     * constructor
     */
    public Address(String houseNo, String street, String town, String county, String postcode)
    {
        this.houseNo = houseNo;
        this.street = street;
        this.town = town;
        this.county = county;
        this.postcode = postcode;
    }
}
