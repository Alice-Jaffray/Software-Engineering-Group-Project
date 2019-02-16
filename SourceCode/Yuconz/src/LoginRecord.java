import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Stores the successful login attempts by users    TEMPORARY UNTIL WE CREATE STATIC RECORDS
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12v2
 */
public class LoginRecord {
    private String username ;
    private String date_time;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");


    /**
     * constructor
     */
    public LoginRecord(String username) {
        this.username = username;
        date_time = dtf.format(LocalDateTime.now());
    }

    /**
     * returns a neatly formated string
     * @return String - neatly formated string containing all the field values
     */
    public String getDetails(){
        return "Name: " + username + "\nTime of Login: " + date_time + "\n";
    }

    /**
     * returns the username of this record
     * @return String - the username stored in this record
     */
    public String getUsername() {
        return username;
    }

    /**
     * returns the date and time the record was taken
     * @return String - date and time of record
     */
    public String getDate_time() {
        return date_time;
    }
}
