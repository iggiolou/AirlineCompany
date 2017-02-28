package by.vdoroshenko;

import by.vdoroshenko.utility.ConsoleReader;
import by.vdoroshenko.utility.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        Main theApp = new Main();
        theApp.runTheApp();
    }

    public void runTheApp() {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;

        InputStream xmlData = null;
        try
        {
            xmlData = new FileInputStream("AircraftList.xml");

            parser = factory.newSAXParser();
            parser.parse(xmlData, new Parser());


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (SAXException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
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
