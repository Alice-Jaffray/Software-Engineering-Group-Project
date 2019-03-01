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
    public String firstReviewer;
    public String secondReviewer;
    public String previousYearAchievements;
    public String trainingAndMentoring;
    public String employeeComments;

    /**
     * constructor
     * @param staffID name of employee who created the document
     */
    public AnnualReview(String staffID, String date, String reviewerSummary, String reviewee,
                        String previousYearAchievements, String trainingAndMentoring, String employeeComments) {
        super(staffID);
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (Exception e) {e.printStackTrace();}
        this.reviewerSummary = reviewerSummary;
        this.reviewee = reviewee;
        this.previousYearAchievements = previousYearAchievements;
        this.trainingAndMentoring = trainingAndMentoring;
        this.employeeComments = employeeComments;
    }

    /**
     * gets the username of the first reviewer
     *
     * @return username of the first reviewer
     */
    public String getFirstReviewer(){
        return firstReviewer;
    }

    /**
     * gets the username of the second reviewer
     *
     * @return username of the second reviewer
     */
    public String getSecondReviewer(){
        return secondReviewer;
    }
}
