package helpers.connection;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.transform.Result;
import java.sql.*;

public class DBConnection {

    private static Connection conn = null;
    private static Statement stmt = null;

    public void getConnection() throws Exception {

        try {
            //            Creating connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeetport", "root", "Dont2Bodies0!");
            //            Creating statement
            stmt = conn.createStatement();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

//region Airlines
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

//    Method for finding one specific row
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

//endregion Airline

//region AIRCRAFT

    //ADD
    public boolean insertAircraft(String type, String name, String model, int capacity, String range, int idAirline, int typeAllowed) throws Exception {

        boolean succ = false;
        try {
            String newQuery = "INSERT INTO aircraft (`type`, `name`, `model`, `capacity`, `range`, `idAirline`, `typeAllowed`) VALUES ('"+type+"', '"+name+"', '"+model+"', "+capacity+", '"+range+"', "+idAirline+", "+typeAllowed+");";
            stmt.executeUpdate(newQuery);
            succ = true;
        }catch (Exception e) {
            System.out.println(e);
        } finally {stmt.close(); conn.close();}

        return succ;
    }

    // Check that the airline's name already exists
    public int checkAirline(String airlineName) throws SQLException {

        int idAirline = 0;
        ResultSet rs = null;

        try {
            rs = stmt.executeQuery("SELECT idAirline FROM airline WHERE name = '"+airlineName+"';");
            while (rs.next())
                idAirline = rs.getInt("idAirline");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return idAirline;
    }

    //Find Aircraft
    public int findAircraft(String name) throws Exception {

        int idAir = 0;
        ResultSet rs = null;
        try {

            rs = stmt.executeQuery("Select idAircraft FROM aircraft WHERE name = '"+name+"'");
            while (rs.next())
                idAir = rs.getInt("idAircraft");
        }catch (Exception e) {
            System.out.println(e.toString());
        }

        return idAir;
    }

    //DELETE
    public void deleteAircraft(int idAircraft){
        try {
            String query = "DELETE FROM aircraft WHERE (idAircraft = '"+idAircraft+"');";
            stmt.executeUpdate(query);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public JSONArray getRowsAircraft() throws Exception {

        ResultSet rs = null;
        JSONArray airRes = new JSONArray();

        try {
//            Execute SQL query
            rs = stmt.executeQuery("Select ac.idAircraft as idAircraft, ac.type as acType, ac.name as name, ac.model as model, ac.capacity as capacity, ac.range as acRange, al.name as airlineName, ac.typeAllowed as typeAllowed from aircraft as ac, airline as al WHERE al.idAirline = ac.idAirline");

//            Iterate result
            while (rs.next()) {
                int idAir = rs.getInt("idAircraft");
                String typeAir = rs.getString("acType");
                String nameAir = rs.getString("name");
                String modelAir = rs.getString("model");
                int captAir = rs.getInt("capacity");
                String rangeAir = rs.getString("acRange");
                String nameAirline = rs.getString("airlineName");
                int typeAllowed = rs.getInt("typeAllowed");

                JSONObject airObj = new JSONObject();
                airObj.put("idAircraft",idAir);
                airObj.put("type", typeAir);
                airObj.put("name", nameAir);
                airObj.put("model", modelAir);
                airObj.put("capacity", captAir);
                airObj.put("range", rangeAir);
                airObj.put("nameAirline", nameAirline);
                airObj.put("typeAllowed", typeAllowed);

                airRes.put(airObj);
            }
        } catch (Exception e) {
            System.out.println("Don't worry, it's normal to panic in these trying times" + e.getStackTrace());
        } finally {rs.close(); stmt.close(); conn.close();}

        return airRes;
    }

    public void updateAircraft(String type, String name, String model, int capacity, String range, int idAirline, int typeAllowed, int idAircraft) throws Exception {

        try {
            String query = "UPDATE aircraft SET `type` = '"+type+"', `name` = '"+name+"', `model` = '"+model+"', `capacity` = "+capacity+", `range` = '"+range+"', `idAirline` = "+idAirline+", `typeAllowed` = "+typeAllowed+" WHERE (`idAircraft` = '"+idAircraft+"')";
            stmt.executeUpdate(query);
        }catch (Exception e) {
            System.out.println(e.toString());
        } finally {stmt.close(); conn.close();}

    }

//endregion AIRCRAFT

}
