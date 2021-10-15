package com.kodigo.classes;

import java.util.ArrayList;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

}
