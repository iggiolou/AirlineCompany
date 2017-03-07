package by.vdoroshenko.utility;

import java.util.Scanner;

/**
 * Created by viktoriyadoroshenko on 2/28/17.
 */
public class ConsoleReader {

    public static int readKeyFromConsole() {
        System.out.println("Make your choice");
        int key;
        Scanner sc = new Scanner(System.in);
        try {
            key = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Your choice is not a number. Please, try again");
            return readKeyFromConsole();
        }

        return key;

    }

}
