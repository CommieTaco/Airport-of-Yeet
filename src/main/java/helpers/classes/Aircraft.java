package helpers.classes;

import helpers.Presenter;
import helpers.connection.DBConnection;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

@Getter @Setter
public class Aircraft {
    private int idAircraft;
    private String type;
    private String name;
    private String model;
    private int capacity;
    private Double range;
    private int IdAirline;
    private int typeAllowed;
    private final DBConnection conn = new DBConnection();


    public boolean addNewAircraft(){

        boolean newSuccess = false;

        try {
            conn.getConnection();
            newSuccess = conn.insertAircraft(type, name, capacity, range, IdAirline);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        return newSuccess;
    }

    public void findAircraft(String name) {

        try {
            conn.getConnection();
            idAircraft = conn.findAircraft(name);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public boolean deleteAircraft(){

        boolean success = false;
        try {
            findAircraft(this.name);
            conn.getConnection();
            conn.deleteAircraft(this.idAircraft);
            success = true;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return success;
    }

    public void getAircraft() {

        try {
            conn.getConnection();
            JSONArray results = conn.getRowsAircraft();
            Presenter presenter = new Presenter();
            presenter.showAircraft(results);

        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}
