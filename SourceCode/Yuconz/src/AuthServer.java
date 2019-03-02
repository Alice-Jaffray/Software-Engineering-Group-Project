import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

/**
 * stores when a successful login takes place
 * mock of server that holds login information.
 * @author Alice Jaffray and Kieran D'Arcy and Isaiah Ojo
 * @version 2019/02/16
 */
public class AuthServer {
    private final String FILENAME = "LoginRecords.csv";

    /**
     * constructor
     */
    public AuthServer() {

    }

    public static void main(String[] args) {
        AuthServer a = new AuthServer();
        System.out.println(a.authenticate("cfi000", "admin"));
        System.out.println(a.insertLogin("mro000", "davidBarnes", "director"));
        System.out.println(a.authenticate("mro000", "davidBarnes"));
    }

    /**
     * Connects to the Authentication database.
     * @return A connection to the database.
     */
    private Connection connect() {
        Connection con = null;
        try{
            String url = "jdbc:sqlite:Databases/Yuconz.db";
            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.exit(0);
        }
        return con;
    }

    /**
     * authenticates the user for login purposes
     * logs the details of the login attempt
     *
     * @param user username of user
     * @param password password of user
     * @return the user who is trying to be authenticated or null if attempt failed
     */
     String authenticate(String user, String password) {
        // SQL Query
        String sql = "select access from users where empID = ? and password = ?;";

        try (Connection con = this.connect();
             PreparedStatement prep = con.prepareStatement(sql)) {
            // Fill placeholders (? characters).
            prep.setString(1, user);
            prep.setString(2, password);

            ResultSet results = prep.executeQuery();
            // Analyse Results
            if(results.getString(1) == null)  {
                return "denied";
            } else {
                return results.getString(1);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return "denied";
        }
    }

    /**
     * Insert a new login into the system.
     * @param username The new user's username.
     * @param password The new user's password.
     * @param access The new user's access level for the system.
     * @return true if succeeded.
     */
    public boolean insertLogin(String username, String password, String access) {
        //Query
        String sql = "INSERT INTO users values (?, ?, ?);";

        try (Connection con = this.connect();
             PreparedStatement prep = con.prepareStatement(sql)) {
            prep.setString(1, username);
            prep.setString(2, password);
            prep.setString(3, access);
            prep.executeUpdate();
            return true;
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
            return false;
        }
    }

    /**
     *
     * @param test
     */
    public void writeToFile(String test){
        BufferedWriter bw = null;
        FileWriter fw = null;

        try{
            String content = test += "\n";
            fw = new FileWriter(FILENAME,true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("File has been written to successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }   finally {
            try {
                if (bw!= null)
                    bw.close();

                if(fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void readFromFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(FILENAME));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

}

