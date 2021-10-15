import helpers.Presenter;
import helpers.connection.DBConnection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Presenter presenter = new Presenter();
        Scanner sc = new Scanner(System.in);

        presenter.mainGreeter();

        String resp = "";

        label:
        while(true){

            if (resp.equals("")){
                presenter.mainMenu();
                resp = sc.nextLine();

                switch (resp) {
                    case "1":
                        DBConnection.getConnection();
                        break;

                    case "2":

                        break;
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
