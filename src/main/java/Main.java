import helpers.Presenter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Presenter presenter = new Presenter();
        Scanner sc = new Scanner(System.in);

        presenter.mainGreeter();

        String resp = "";

        while(true){

            if (resp.equals("")){
                presenter.mainMenu();
                resp = sc.nextLine();

                if (resp.equals("1")){

                }
                else if (resp.equals("2")){

                }
                else if (resp.equals("3")){

                }
                else if (resp.equals("4")){

                }
                else if (resp.equals("5")){

                }
                else if (resp.equals("6")){

                }
                else if (resp.equals("7")){
                    presenter.farewellMessage();
                    break;
                }
                else {
                    System.out.println(
                            """
                            ┌------------------------------┐
                            | Please enter a valid  number |
                            └------------------------------┘
                            """);
                    resp = "";
                }
            }

            System.out.println(resp);
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
