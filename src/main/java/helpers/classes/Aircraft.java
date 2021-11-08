package helpers.classes;

import helpers.Presenter;
import helpers.connection.DBConnection;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import java.util.Scanner;

@Getter @Setter
public class Aircraft {
    private int idAircraft;
    private String type;
    private String name;
    private String model;
    private int capacity;
    private String range;
    private int idAirline;
    private int typeAllowed;
    private String nameAirline;
    private final DBConnection conn = new DBConnection();


    public String addNewAircraft(){

        String newRes = "";
        boolean newSuccess = false;
        int checkAirline = 0;
        Presenter presenter = new Presenter();

        try {
            conn.getConnection();
            checkAirline = conn.checkAirline(this.nameAirline);

            if (checkAirline != 0) {
                this.setIdAirline(checkAirline);

                newSuccess = conn.insertAircraft(this.type, this.name, this.model, this.capacity, this.range, this.idAirline, this.typeAllowed);
                if (newSuccess)
                    return newRes = "Success";
                else
                    return newRes = "Fail";

            } else if (checkAirline == 0)
                return newRes = "NoAir";

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return newRes;
    }


    public boolean deleteAircraft(){

        boolean success = false;
        try {
            findAircraft();
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

//    To find a specific aircraft
    public void findAircraft() {

        try {
            conn.getConnection();
            idAircraft = conn.findAircraft(this.name);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public String updateAircraft() throws Exception {

        Scanner sc = new Scanner(System.in);
        String updRes = "Failed";
        int checkAirline = 0;
        try {
            findAircraft();
            Presenter presenter = new Presenter();
            presenter.aircraftMenuUpdateType(this.name);
            this.type = sc.nextLine();
            presenter.aircraftMenuUpdateName(this.name);
            this.name = sc.nextLine();
            presenter.aircraftMenuUpdateModel(this.name);
            this.model = sc.nextLine();
            presenter.aircraftMenuUpdateCapacity(this.name);
            this.capacity = sc.nextInt();
            presenter.aircraftMenuUpdateRange(this.name);
            sc.nextLine();
            this.range = sc.nextLine();
            presenter.aircraftMenuUpdateAirline(this.name);
            this.nameAirline = sc.nextLine();
            checkAirline = conn.checkAirline(this.nameAirline);
            if (checkAirline != 0)
                this.setIdAirline(checkAirline);
            else if (checkAirline == 0)
                return updRes = "NoAir";

            presenter.aircraftMenuUpdateAllowed(this.name);
            String allowedRes = sc.nextLine();
            if (allowedRes.equals("Yes") || allowedRes.equals("yes"))
                setTypeAllowed(1);
            else if (allowedRes.equals("No") || allowedRes.equals("no"))
                setTypeAllowed(2);
            else
                System.out.println("Please write \"Yes\" or \"No\"");


            conn.getConnection();
            conn.updateAircraft(this.type,this.name,this.model, this.capacity, this.range, this.idAirline, this.typeAllowed, this.idAircraft);
            updRes = "Success";
        } catch (Exception e) {
                System.out.println(e.toString());
            }

        return updRes;
    }

}
