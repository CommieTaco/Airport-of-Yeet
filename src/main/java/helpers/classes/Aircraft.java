package helpers.classes;


public class Aircraft {
    private int ID_aircraft;
    private String type;
    private String name;
    private String model;
    private int capacity;
    private double range;
    private int ID_airline;
    private int typeallowed;

    public int getID_aircraft() {
        return this.ID_aircraft;
    }

    public void setID_aircraft(int ID_aircraft) {
        this.ID_aircraft = ID_aircraft;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRange() {
        return this.range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getID_airline() {
        return this.ID_airline;
    }

    public void setID_airline(int ID_airline) {
        this.ID_airline = ID_airline;
    }

    public int getTypeallowed() {
        return this.typeallowed;
    }

    public void setTypeallowed(int typeallowed) {
        this.typeallowed = typeallowed;
    }

}
