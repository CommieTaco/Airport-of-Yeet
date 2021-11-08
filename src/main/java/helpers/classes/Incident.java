package helpers.classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Incident {

    private int idIncident;
    private String typeIncident;
    private String dateIncident;
    private String timeIncident;
    private int idFlight;
    private String description;

    public void insertIncident(){

    }
}
