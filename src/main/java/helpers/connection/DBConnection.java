package helpers.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static void getConnection() throws Exception{

//            Creating connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeetport", "root", "Dont2Bodies0!");
//            Creating statement
        Statement stmt = conn.createStatement();

        ResultSet rs = null;
        try {
//            Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM airline");
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
        }

//        return conn;
    }
}
