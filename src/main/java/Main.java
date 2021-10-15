import helpers.Presenter;
import helpers.classes.Cancellation;
import helpers.classes.Flights;
import helpers.connection.DBConnection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Presenter presenter = new Presenter();
        Scanner sc = new Scanner(System.in);
        boolean breakLoop = false;

        presenter.mainGreeter();

        String resp = "";

        userInput: while(true){

            if (resp.equals("")){
                presenter.mainMenu();
                resp = sc.nextLine();

                label:
                switch (resp) {
                    case "1":
                        String flResp;
                        presenter.flightsMenu();
                        flResp = sc.nextLine();

//                        Add flight
                        switch (flResp) {
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
                            default:
                                System.out.println(
                                        """
                                                ┌------------------------------┐
                                                | Please enter a valid  number |
                                                └------------------------------┘
                                                """);
                                break label;
                        }

                        Flights flights = new Flights();
                        resp = "";
                        break userInput;

                    case "2":

                        Cancellation can = new Cancellation();
                        break userInput;
                    case "3":


                        break userInput;
                    case "4":

                        break userInput;
                    case "5":

                        break userInput;
                    case "6":

                        break userInput;
                    case "7":
                        presenter.farewellMessage();
                        break userInput;
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
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
