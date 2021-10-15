import helpers.Presenter;
import helpers.classes.Airline;
import helpers.classes.Cancellation;
import helpers.classes.Flights;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Presenter presenter = new Presenter();
        Scanner sc = new Scanner(System.in);
        boolean breakLoop = false;

        presenter.mainGreeter();

        String resp = "";

        userInputSwitch: while(true){

            if (resp.equals("")){
                presenter.mainMenu();
                resp = sc.nextLine();

                respSwitch:
                switch (resp) {
//region                    Flights option
                    case "1":
                        String flResp;
                        presenter.flightsMenu();
                        flResp = sc.nextLine();

//                        Add flight
                        flightResponseSwitch: switch (flResp) {

                            case "1":

                                presenter.flightsMenuAddOrigin();
                                String flOrigin = sc.nextLine();
                                presenter.flightsMenuAddDest();
                                String flDest = sc.nextLine();
                                presenter.flightsMenuAddDateDep();
                                String flDateDep = sc.nextLine();
                                presenter.flightsMenuAddDateArri();
                                String flDateArri = sc.nextLine();
                                presenter.flightsMenuAddTimeDep();
                                String flTimeDep = sc.nextLine();
                                presenter.flightsMenuAddTimeArri();
                                String flTimeArri = sc.nextLine();
                                presenter.flightsMenuAddNameAirc();
                                String flNameAirc = sc.nextLine();
                                presenter.flightsMenuAddNameAirpo();
                                String flNameAirport = sc.nextLine();


                                break;
//                        Update flight
                            case "2":

                                break;
//                        Get info about a flight
                            case "3":

                                break;
//                        Cancel a flight
                            case "4":

                                break;
//                        Go back
                            case "5":

                                break flightResponseSwitch;
                            default:
                                System.out.println(
                                        """
                                                ┌------------------------------┐
                                                | Please enter a valid  number |
                                                └------------------------------┘
                                                """);
                                resp = "1";
                                return;
                        }

                        Flights flights = new Flights();
                        resp = "";
                        break userInputSwitch;
//endregion Ends flights option
//region                Aircraft option
                    case "2":

                        Cancellation can = new Cancellation();
                        break userInputSwitch;
//endregion             Ends Aircraft option
//region                Airlines option
                    case "3":
                        presenter.airlinesMenu();
                        String airResp = sc.nextLine();
                        Airline airline = new Airline();

                        switch (airResp){
//                          Create new airline
                            case "1":

                                presenter.airlinesMenuAddName();
                                airline.setName(sc.nextLine());
                                presenter.airlinesMenuAddCountryOri();
                                airline.setCountryReg(sc.nextLine());
                                boolean success = airline.addNewAirline();

                                if (success)
                                    System.out.println("New airline created successfully");
                                else
                                    System.out.println("We couldn't create the new airline");
                                break;
//                                Update airline
                            case "2":

                                presenter.airlinesMenuUpdateSearch();
                                airline.setName(sc.nextLine());
                                boolean updated = airline.updateAirline();

                                if (updated)
                                    System.out.println("Airline has been updated");
                                else
                                    System.out.println("There was an error whilst updating the airline");
                                break;
//                                Delete an airline
                            case "3":

                                presenter.airlinesMenuDelete();
                                airline.setName(sc.nextLine());
                                boolean deleted = airline.deleteAirline();

                                if (deleted)
                                    System.out.println("Airline has been deleted");
                                else
                                    System.out.println("There was an error whilst deleting the airline");

                                break;
//                                View all airlines
                            case "4":

                                airline.getAirlines();

                                System.out.println("""
                                            ┌-------------- View the airlines -------------┐
                                            | ■ Press Enter to continue                    |
                                            └--- Write data and press Enter to continue ---┘
                                        """);
                                sc.nextLine();

                                break;
                            case "5":

                                break;
                            default:

                                break;
                        }

                        break userInputSwitch;
//endregion             Ends Airlines option
//region                Import flights from Excel option
                    case "4":

                        break userInputSwitch;
//endregion             Ends import flights from Excel option
//region                Export flights to Excel option
                    case "5":

                        break userInputSwitch;
//endregion             Ends export flights to Excel option
//region                Check weather option
                    case "6":

                        break userInputSwitch;
//endregion             Ends check weather option
//region                Exit option
                    case "7":
                        presenter.farewellMessage();
                        break userInputSwitch;
//endregion             Ends exit option
                    default:
                        System.out.println(
                                """
                                        ┌------------------------------┐
                                        | Please enter a valid  number |
                                        └------------------------------┘
                                        """);
                        resp = "";
                        break;
                }
            }

            System.out.println(resp);
        }
    }
}
