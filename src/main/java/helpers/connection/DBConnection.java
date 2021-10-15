package helpers.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void getConnection() throws Exception{

//            Creating connection
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeetport", "root", "Dont2Bodies0!");
//            Creating statement
        stmt = conn.createStatement();
    }

    public static List getRows(String tableName) throws Exception{

        ResultSet rs = null;
        List<String> results = new ArrayList<>();
        try {
//            Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM " + tableName);
//            Iterate result
            while (rs.next()){
                System.out.println(rs.getString("name") + " from " + rs.getString("countryRegistration"));

            }
        }catch (Exception e) {
            System.out.println("Don't worry, it's normal to panic in these trying times" + e);
        }
        finally {
            rs.close();
            stmt.close();
            conn.close();

            return results;
        }
    }

    public static String getRow() {

        String results = "";

        return results;
    }

    public static void insertRow() throws Exception{

        System.out.println("Conn: "+conn);

    }
}
