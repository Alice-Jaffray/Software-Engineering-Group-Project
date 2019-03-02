import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

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
        System.out.print(a.authenticate("aja000", "password"));
    }

    /**
     * authenticates the user for login purposes
     * logs the details of the login attempt
     *
     * @param user username of user
     * @param password password of user
     * @return the user who is trying to be authenticated or null if attempt failed
     */
    public String authenticate(String user, String password) {
        // SQL Query
        String sql = "select access from users where empID = ? and password = ?;";


        try (Connection con = this.connect();
             PreparedStatement prep = con.prepareStatement(sql)) {
            prep.setString(1, user);
            prep.setString(2, password);
            ResultSet results = prep.executeQuery();
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
/*
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

    public void readFromFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(FILENAME));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }
    *//**
     * removes details from auth server
     * @param name username of te user
     * @param password password of the user
     *//*
    public void removeDetails(String name, String password){
        for (User users : loginDetails) {
            if(users.getUsername().equals(name) && users.getPassword().equals(password)) {
                loginDetails.remove(users);
                System.out.println("User '" + name + "' as been removed");
                break;
            }
        }
    }

    *//**
     * get all the login records
     * if the user is a HR employee
     *
     * @param user the user attempting to get the login records
     * @return the login records if the user is a HR employee and null otherwise
     *//*
    public ArrayList<LoginRecord> getLoginRecords(User user) {
        if (user.getAccessLevel().equals("hremployee")){
            return loginRecords;
        } else {
            return null;
        }
    }

    *//**
     * prints the the login records
     * if the user is a HR employee
     * @param user the user attempting to print the login records
     * @return true if the records were printed and false if not
     *//*
    public boolean printLoginRecords(User user) {
        if (user.getAccessLevel().equals("hremployee")){
            for (LoginRecord records : loginRecords) {
                System.out.println(records.getDetails());
            }
            return true;
        } else {
            return false;
        }
    }*/
}

