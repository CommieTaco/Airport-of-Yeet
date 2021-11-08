package helpers.classes;

import java.util.ArrayList;
import java.util.Date;

import helpers.Presenter;
import helpers.connection.DBConnection;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import scala.collection.immutable.List;

@Getter @Setter
public class Flights {

    private int idFlight;
    private String status;
    private String origin;
    private String destination;
    private String dateDepart;
    private String dateArriv;
    private String timeDepart;
    private String timeArriv;
    private String nameAircraft;
    private int idAircraft;
    private String airport;
    private ArrayList<Flights> flights;
    private final DBConnection conn = new DBConnection();

    public Flights(){
        flights = new ArrayList<>();
    }

    public void showFlights(){

        try {
            conn.getConnection();
            JSONArray results = conn.getRowsFlights();
            Presenter presenter = new Presenter();
            presenter.showFlights(results);

        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

//    public boolean addNewFlight(){
//
//        boolean success = false;
//
//        try {
//            conn.getConnection();
//            success = conn.insertFlight(this.status, this.origin, this.destination, this.dateDepart, this.dateArriv, this.timeDepart, this.timeArriv, this.idAircraft, this.airport);
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        return success;
//    }
    
}
