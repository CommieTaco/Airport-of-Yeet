package helpers.classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Aircraft {
	private int ID_aircraft;
    private String type;
    private String name;
    private String model;
    private int capacity;
    private double range;
    private int ID_airline;
    private int typeallowed;

}

