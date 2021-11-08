import helpers.Presenter;
import helpers.classes.Aircraft;
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
                        Flights flights = new Flights();

//                        Add flight
                        flightResponseSwitch: switch (flResp) {

                            case "1":

                                presenter.flightsMenuAddOrigin();
                                flights.setOrigin(sc.nextLine());
                                presenter.flightsMenuAddDest();
                                flights.setDestination(sc.nextLine());
                                presenter.flightsMenuAddDateDep();
                                flights.setDateDepart(sc.nextLine());
                                presenter.flightsMenuAddDateArri();
                                flights.setDateArriv(sc.nextLine());
                                presenter.flightsMenuAddTimeDep();
                                flights.setTimeDepart(sc.nextLine());
                                presenter.flightsMenuAddTimeArri();
                                flights.setTimeArriv(sc.nextLine());
                                presenter.flightsMenuAddNameAirc();
                                flights.setNameAircraft(sc.nextLine());
                                presenter.flightsMenuAddNameAirpo();
                                flights.setAirport(sc.nextLine());

//                                flights.addNewFlight();

                                break;
//                        Update flight
                            case "2":

                                break;
//                        Show all flights
                            case "3":
                                flights.showFlights();
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
                        resp = "";
                        break userInputSwitch;
//endregion Ends flights option
//region                Aircraft option
                    case "2":

                        Cancellation can = new Cancellation();

                        Aircraft aircraft = new Aircraft();
                        String arcResp;
                        presenter.aircraftMenu();
                        arcResp = sc.nextLine();
                        switch (arcResp){
                            //create new aircraft
                            case "1":
                                presenter.aircraftMenuAddType();
                                aircraft.setType(sc.nextLine());
                                presenter.aircraftMenuAddName();
                                aircraft.setName(sc.nextLine());
                                presenter.aircraftMenuAddModel();
                                aircraft.setModel(sc.nextLine());
                                presenter.aircraftMenuAddCapacity();
                                aircraft.setCapacity(sc.nextInt());
                                presenter.aircraftMenuAddRange();
                                sc.nextLine();
                                aircraft.setRange(sc.nextLine());
                                presenter.aircraftMenuAddAirlineName();
                                aircraft.setNameAirline(sc.nextLine());
                                presenter.aircraftMenuAddAirlineAllowed();
                                String allowedRes = sc.nextLine();
                                if (allowedRes.equals("Yes") || allowedRes.equals("yes"))
                                    aircraft.setTypeAllowed(1);
                                else if (allowedRes.equals("No") || allowedRes.equals("no"))
                                    aircraft.setTypeAllowed(2);
                                else
                                    System.out.println("Please write \"Yes\" or \"No\"");
                                String success = aircraft.addNewAircraft();

                                if (success.equals("Success"))
                                    System.out.println("New aircraft created successfully");
                                else if (success.equals("Fail"))
                                    System.out.println("We couldn't create the new aircraft");
                                else if (success.equals("NoAir"))
                                    System.out.println("The airline you're trying to associate does not exist.\n Please create the new airline or write a different name.");
                                break;
                            //delete an aircraft
                            case "2":
                                presenter.aircraftMenuDeleteAircraft();
                                aircraft.setName(sc.nextLine());
                                boolean deleted = aircraft.deleteAircraft();

                                if (deleted)
                                    System.out.println("Aircraft has been deleted");
                                else
                                    System.out.println("There was an error whilst deleting the aircraft");
                                break;
                            //view all aircraft
                            case "3":
                                aircraft.getAircraft();
                                break;
//                                Update aircraft
                            case "4":
                                presenter.aircraftMenuUpdateSearch();
                                aircraft.setName(sc.nextLine());

                                String updated = aircraft.updateAircraft();
                                if (updated.equals("Success"))
                                    System.out.println("Aircraft updated successfully");
                                else if (updated.equals("Failed"))
                                    System.out.println("There was an error whilst updating the aircraft");
                                else if (updated.equals("NoAir"))
                                    System.out.println("The airline you're trying to associate does not exist.\n Please create the new airline or write a different name.");

                                break;
                            default:

                                break;
                        }
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
                                presenter.mainMenu();
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
