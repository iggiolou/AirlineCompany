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

public class Main {

    Parser mainParser = new Parser();

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
        SAXParser parser;

        InputStream xmlData = null;
        try {
            xmlData = new FileInputStream(new File("AircraftList.xml"));

            parser = factory.newSAXParser();
            parser.parse(xmlData, mainParser);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            switch (showMenu()){
                case 1:
                    mainParser.getAirlineCompany().showAircraftList();
                    break;
                case 2:
                case 3:
                    System.out.println("See you later! Bye!");
                    System.exit(0);
            }

    }

    public int showMenu(){
        System.out.println("Welcome to our Airline company!");
        System.out.println("===========Menu================");
        System.out.println("Press 1 to see all the planes");
        System.out.println("Press 2 to see planes by category");
        System.out.println("Press 3 to exit");
        return ConsoleReader.readKeyFromConsole();
    }

    }

