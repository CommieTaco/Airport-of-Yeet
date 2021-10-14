import helpers.Presenter;
import helpers.Testme;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Presenter presenter = new Presenter();
        Scanner sc = new Scanner(System.in);

        presenter.mainGreeter();
        presenter.mainMenu();

        String resp;
        Integer shrek;

        while(true){
            System.out.println("Do you want out?");
            resp = sc.nextLine();
            System.out.println(resp);
            if (resp.equals("Out") || resp.equals("y"))
                break;
            else if (resp.equals("El Pepe")){
                new Testme(resp);
            }

            System.out.println("Do you want Shrek?");
            shrek = sc.nextInt();
            sc.nextLine();
            System.out.println(shrek);
        }
    }
}
