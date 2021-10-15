package helpers.classes;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import scala.collection.immutable.List;

@Getter @Setter
public class Flights {

    public int IdFlight;
    public String status;
    public String origin;
    public String destination;
    public Date dateDepart;
    public Date dateArriv;
    public String timeDepart;
    public String timeArriv;
    private int IdAircraft;
    private int IdAirport;
    public ArrayList<Flights> flights;

    public Flights(){
        flights = new ArrayList<>();
    }

    
}
