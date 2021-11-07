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

//    public boolean updateAircraft(){
//
//        Scanner sc = new Scanner(System.in);
//        boolean success = false;
//        try {
//            Presenter presenter = new Presenter();
//            presenter.airlinesMenuUpdateName(name);
//            this.name = sc.nextLine();
//            presenter.airlinesMenuUpdateOri(name);
//            this.countryReg = sc.nextLine();
//            findAirline(this.name);
//
//            conn.getConnection();
//            conn.updateAirline(name,countryReg,idAirline);
//
//            success = true;
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//
//        return success;
//    }

}
