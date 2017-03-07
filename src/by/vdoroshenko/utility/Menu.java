package by.vdoroshenko.utility;

import java.util.Scanner;

/**
 * Created by viktoriyadoroshenko on 3/7/17.
 */
public class Menu {

    Parser parser;

    public void showMenu() {
        while (true) {
            switch (showMenuItems()) {
                case 1:
                    parser.getAirlineCompany().showAircraftList();
                    break;
                case 2:
                    parser.getAirlineCompany().showSortedAircraftList();
                    break;
                case 3:
                    System.out.println("Enter Airplane name");
                    Scanner sc = new Scanner(System.in);
                    String searchValue = sc.next();
                    parser.getAirlineCompany().searchAircraft(searchValue);
                    break;
                case 4:
                    System.out.println("See you later! Bye!");
                    System.exit(0);
            }
        }

    }

    public static int showMenuItems() {
        System.out.println("Welcome to our Airline company!");
        System.out.println("===========Menu================");
        System.out.println("Press 1 to see all the planes");
        System.out.println("Press 2 to sorted by name planes");
        System.out.println("Press 3 to search for plane");
        System.out.println("Press 4 to exit");
        return ConsoleReader.readKeyFromConsole();
    }
}
