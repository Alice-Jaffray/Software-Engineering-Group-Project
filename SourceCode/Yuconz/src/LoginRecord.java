import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Stores the successful login attempts by users
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 1.0 2019/02/05
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


}
