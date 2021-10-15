import helpers.Presenter;
import helpers.classes.Cancellation;
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

                switch (resp) {
                    case "1":
                        DBConnection.getConnection();
                        DBConnection.insertRow();
                        resp = "";
                        break userInput;

                    case "2":
                        presenter.flightsMenu();
                        Cancellation can = new Cancellation();
                        break userInput;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":
                        presenter.farewellMessage();
                        break;
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
