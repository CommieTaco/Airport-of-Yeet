package helpers.classes;

import java.util.ArrayList;
import java.util.Date;

import scala.collection.immutable.List;

public class Flights {
    public int ID_flight;
    public String status;
    public String origin;
    public String destination;
    public Date date_depart;
    public Date date_arriv;
    public String time_depart;
    public String time_arriv;
    private int ID_cancell;
    private int ID_aircraft;
    private int ID_incident;
    private int ID_airport;
    public ArrayList<Flights> flights;

    public Flights(){
        flights = new ArrayList<Flights>();
    }

    public int getID_flight() {
        return this.ID_flight;
    }

    public void setID_flight(int ID_flight) {
        this.ID_flight = ID_flight;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate_depart() {
        return this.date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public Date getDate_arriv() {
        return this.date_arriv;
    }

    public void setDate_arriv(Date date_arriv) {
        this.date_arriv = date_arriv;
    }

    public String getTime_depart() {
        return this.time_depart;
    }

    public void setTime_depart(String time_depart) {
        this.time_depart = time_depart;
    }

    public String getTime_arriv() {
        return this.time_arriv;
    }

    public void setTime_arriv(String time_arriv) {
        this.time_arriv = time_arriv;
    }

    public int getID_cancell() {
        return this.ID_cancell;
    }

    public void setID_cancell(int ID_cancell) {
        this.ID_cancell = ID_cancell;
    }

    public int getID_aircraft() {
        return this.ID_aircraft;
    }

    public void setID_aircraft(int ID_aircraft) {
        this.ID_aircraft = ID_aircraft;
    }

    public int getID_incident() {
        return this.ID_incident;
    }

    public void setID_incident(int ID_incident) {
        this.ID_incident = ID_incident;
    }

    public int getID_airport() {
        return this.ID_airport;
    }

    public void setID_airport(int ID_airport) {
        this.ID_airport = ID_airport;
    }

    
}
