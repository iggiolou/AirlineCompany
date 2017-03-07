package by.vdoroshenko;

import by.vdoroshenko.entity.Aircraft;
import by.vdoroshenko.entity.AirlineCompany;
import by.vdoroshenko.utility.Menu;
import by.vdoroshenko.utility.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main theApp = new Main();
        theApp.runTheApp();
    }

    public void runTheApp() {

        Menu menu = new Menu();
        menu.showMenu();

        Parser parser = new Parser();
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

    }

}

