import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * subclass of document
 * stores the details needed for employee's annual review record
 *
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/28
 */
public class AnnualReview extends Document{
    public Date date;
    public String reviewerSummary;
    public String reviewee;
    public String previousYearAchievements;
    public String trainingAndMentoring;
    public String employeeComments;

    /**
     * constructor
     * @param creator name of employee who created the document
     */
    public AnnualReview(String creator, String date, String reviewerSummary, String reviewee,
                        String previousYearAchievements, String trainingAndMentoring, String employeeComments) {
        super(creator);
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (Exception e) {e.printStackTrace();}
        this.reviewerSummary = reviewerSummary;
        this.reviewee = reviewee;
        this.previousYearAchievements = previousYearAchievements;
        this.trainingAndMentoring = trainingAndMentoring;
        this.employeeComments = employeeComments;
    }
}
