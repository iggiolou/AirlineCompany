package by.vdoroshenko.utility;

import by.vdoroshenko.builder.AircraftBuilder;
import by.vdoroshenko.builder.CargoAircraftBuilder;
import by.vdoroshenko.builder.CivilAircraftBuilder;
import by.vdoroshenko.builder.MilitaryAircraftBuilder;
import by.vdoroshenko.entity.Aircraft;
import by.vdoroshenko.entity.AircraftType;
import by.vdoroshenko.entity.AirlineCompany;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class Parser extends DefaultHandler {

    public static final String AIRPLANE_TYPE = "AirplaneType";
    public static final String AIRPLANE_NAME = "AirplaneName";
    public static final String MAX_SPEED = "MaxSpeed";
    public static final String PASSANGER_AMOUNT = "PassangerAmount";
    public static final String CAPACITY = "Capacity";
    public static final String RANGE = "Range";
    public static final String LENGTH  = "Length";
    public static final String MILITARY_TYPE  = "MilitaryType";
    public static final String GUN_TYPE = "GunType";

    private String currentTag;
    AirlineCompany airlineCompany = new AirlineCompany();
    List<Aircraft> aircraftList;
    private AircraftBuilder aircraftBuilder;


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        aircraftList = new ArrayList<>();
        System.out.println("Downloading list of planes...");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Tag: " + qName);
        switch (qName) {
            case "CargoAirplane":
                aircraftBuilder = new CargoAircraftBuilder();
                break;
            case "CivilAirplane":
                aircraftBuilder = new CivilAircraftBuilder();
                break;
            case "MilitaryAirplane":
                aircraftBuilder = new MilitaryAircraftBuilder();
                break;
            default:
                throw new IllegalArgumentException("Tag " + qName +  " not found");
        }
        aircraftBuilder.setId(Integer.parseInt(attributes.getValue("id")));
        currentTag = qName;
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        for (int i = start; i < start + length; ++i) {
            System.out.print(ch[i]);
        }
        String tagValue = new String(ch);

        switch (currentTag) {
            case AIRPLANE_NAME:
                aircraftBuilder.setName(tagValue);
            case AIRPLANE_TYPE:
                aircraftBuilder.setType(AircraftType.defineValue(tagValue));
            case PASSANGER_AMOUNT:
                ((CivilAircraftBuilder)aircraftBuilder).setAircraftPassengerAmount(Integer.parseInt(tagValue));
            case CAPACITY:
                ((CargoAircraftBuilder)aircraftBuilder).setAircraftCapacity(tagValue);
            case RANGE:
                ((CivilAircraftBuilder)aircraftBuilder).setAircraftRange(tagValue);
            case MAX_SPEED:
                aircraftBuilder.setMaxSpeed(tagValue);
            case LENGTH:
                ((CargoAircraftBuilder)aircraftBuilder).setAircraftLength(tagValue);
            case MILITARY_TYPE:
                ((MilitaryAircraftBuilder)aircraftBuilder).setAircraftMilitaryType(tagValue);
            case GUN_TYPE:
                ((MilitaryAircraftBuilder)aircraftBuilder).setAircraftGunType(tagValue);
        }

        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        airlineCompany.addAircraft(aircraftBuilder.buildAircraft());
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("List of planes is downloaded!");
    }
}
