package helpers.classes;

import helpers.Presenter;
import helpers.connection.DBConnection;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

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

    public void findAirline(String name) {


        try {
            conn.getConnection();
            idAirline = conn.findAirline(name);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public boolean updateAirline(){

        Scanner sc = new Scanner(System.in);
        boolean success = false;
        try {
            findAirline(this.name);
            Presenter presenter = new Presenter();
            presenter.airlinesMenuUpdateName(name);
            this.name = sc.nextLine();
            presenter.airlinesMenuUpdateOri(name);
            this.countryReg = sc.nextLine();

            conn.getConnection();
            conn.updateAirline(name,countryReg,idAirline);

            success = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return success;
    }

    public boolean deleteAirline(){

        boolean success = false;
        try {
            findAirline(this.name);
            conn.getConnection();
            conn.deleteAirline(this.idAirline);
            success = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return success;
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
