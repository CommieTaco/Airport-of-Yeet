package helpers.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    private static Connection conn = null;
    private static Statement stmt = null;

    public void getConnection() throws Exception {

        try {
            //            Creating connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeetport", "root", "");
            //            Creating statement
            stmt = conn.createStatement();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public JSONArray getRowsAirlines() throws Exception {

        ResultSet rs = null;
        JSONArray airRes = new JSONArray();

        try {
//            Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM airline");

//            Iterate result
            while (rs.next()) {
                int idAir = rs.getInt("idAirline");
                String nameAir = rs.getString("name");
                String countAir = rs.getString("countryRegistration");
                JSONObject airObj = new JSONObject();
                airObj.put("idAirline",idAir);
                airObj.put("name", nameAir);
                airObj.put("countryRegistration", countAir);

                airRes.put(airObj);
            }
        } catch (Exception e) {
            System.out.println("Don't worry, it's normal to panic in these trying times" + e.getStackTrace());
        } finally {rs.close(); stmt.close(); conn.close();}

        return airRes;
    }

    public static String getRow() {

        String results = "";

        return results;
    }

    public boolean insertAirline(String name, String countryOri) throws Exception {

        boolean succ = false;
        try {
            String newQuery = "INSERT INTO airline (name, countryRegistration) VALUES ('"+name+"', '"+countryOri+"');";
            stmt.executeUpdate(newQuery);
            succ = true;
        }catch (Exception e) {
            System.out.println(e.toString());
        } finally {stmt.close(); conn.close();}

        return succ;
    }

    public int findAirline(String name) throws Exception {

        int idAir = 0;
        ResultSet rs = null;
        try {

            rs = stmt.executeQuery("Select idAirline FROM airline WHERE name = '"+name+"'");
            while (rs.next())
                idAir = rs.getInt("idAirline");
        }catch (Exception e) {
            System.out.println(e.toString());
        } finally {rs.close(); stmt.close(); conn.close();}

        return idAir;
    }

    public void updateAirline(String name, String countryOri, int idAirline) throws Exception {

        try {
            String query = "UPDATE airline SET name = '"+name+"', countryRegistration = '"+countryOri+"' WHERE (idAirline = '"+idAirline+"');";
            stmt.executeUpdate(query);
        }catch (Exception e) {
            System.out.println(e.toString());
        } finally {stmt.close(); conn.close();}
    }

    public void deleteAirline(int idAirline) {
        try {
            String query = "DELETE FROM airline WHERE (idAirline = '"+idAirline+"');";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
