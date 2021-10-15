package helpers.classes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Aircraft {
    private int IdAircraft;
    private String type;
    private String name;
    private String model;
    private int capacity;
    private double range;
    private int IdAirline;
    private int typeAllowed;

}
