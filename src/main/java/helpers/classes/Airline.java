package helpers.classes;

import helpers.Presenter;
import helpers.connection.DBConnection;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import scala.math.ScalaNumericAnyConversions;

import java.awt.*;
import java.util.Scanner;

@Getter @Setter
public class Airline {

    private int idAirline;
    private String name;
    private String countryReg;
    private final DBConnection conn = new DBConnection();

    public boolean addNewAirline(){

        boolean newSuccess = false;

        try {
            conn.getConnection();
            newSuccess = conn.insertAirline(name, countryReg);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        return newSuccess;
    }

    public boolean findAirline(String name) {

        boolean success = false;
        Scanner sc = new Scanner(System.in);
        try {
            conn.getConnection();
            idAirline = conn.findAirline(name);
            System.out.println("ID: "+this.idAirline);
            Presenter presenter = new Presenter();
            presenter.airlinesMenuUpdateName(name);
            this.name = sc.nextLine();
            System.out.println(this.name);
            presenter.airlinesMenuUpdateOri(name);
            this.countryReg = sc.nextLine();
            System.out.println(this.countryReg);

            this.updateAirline();
            success = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return success;
    }

    public void updateAirline(){

        try {
            conn.getConnection();
            conn.updateAirline(name,countryReg,idAirline);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

//    List of airlines
    public void getAirlines() {

        try {
            conn.getConnection();
            JSONArray results = conn.getRowsAirlines();
            Presenter presenter = new Presenter();
            presenter.showAirlines(results);

        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

//    Get a specific airline
//    public String getAirline()
}
