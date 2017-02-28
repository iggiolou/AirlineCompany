package by.vdoroshenko;

import by.vdoroshenko.entity.Aircraft;
import by.vdoroshenko.entity.AirlineCompany;
import by.vdoroshenko.utility.ConsoleReader;
import by.vdoroshenko.utility.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Parser parser = new Parser();

    public static void main(String[] args) {
        Main theApp = new Main();
        theApp.runTheApp();
    }

    public void runTheApp() {
        AirlineCompany airlineCompany = new AirlineCompany();
        List<Aircraft> aircrafts = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser saxParser;

        InputStream xmlData = null;
        try {
            xmlData = new FileInputStream(new File("AircraftList.xml"));

            saxParser = factory.newSAXParser();
            saxParser.parse(xmlData, parser);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (showMenu()) {
            case 1:
                parser.getAirlineCompany().showAircraftList();
                break;
            case 2:
                parser.getAirlineCompany().showSortedAircraftList();
            case 3:
                System.out.println("Enter Airplane name");
                Scanner sc = new Scanner(System.in);
                String searchValue = sc.next();
                parser.getAirlineCompany().searchAircraft(searchValue);
            case 4:
                System.out.println("See you later! Bye!");
                System.exit(0);
        }

    }

    public int showMenu() {
        System.out.println("Welcome to our Airline company!");
        System.out.println("===========Menu================");
        System.out.println("Press 1 to see all the planes");
        System.out.println("Press 2 to sorted by name planes");
        System.out.println("Press 3 to search for plane");
        System.out.println("Press 4 to exit");
        return ConsoleReader.readKeyFromConsole();
    }

}

