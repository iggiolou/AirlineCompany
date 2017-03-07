package by.vdoroshenko.utility;

import by.vdoroshenko.builder.AircraftBuilder;
import by.vdoroshenko.builder.CargoAircraftBuilder;
import by.vdoroshenko.builder.CivilAircraftBuilder;
import by.vdoroshenko.builder.MilitaryAircraftBuilder;
import by.vdoroshenko.entity.AircraftType;
import by.vdoroshenko.entity.AirlineCompany;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class Parser extends DefaultHandler {

    private static final String AIRPLANE_TYPE = "AirplaneType";
    private static final String AIRPLANE_NAME = "AirplaneName";
    private static final String MAX_SPEED = "MaxSpeed";
    private static final String PASSANGER_AMOUNT = "PassangerAmount";
    private static final String CAPACITY = "Capacity";
    private static final String RANGE = "Range";
    private static final String LENGTH = "Length";
    private static final String MILITARY_TYPE = "MilitaryType";
    private static final String GUN_TYPE = "GunType";
    private static final String CARGO_AIRPLANE = "CargoAirplane";
    private static final String CIVIL_AIRPLANE = "CivilAirplane";
    private static final String MILITARY_AIRPLANE = "MilitaryAirplane";
    private static final String AIRPLANE_INFO = "AirplaneInfo";

    private String currentTag;

    private AirlineCompany airlineCompany;
    private AircraftBuilder aircraftBuilder;

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        airlineCompany = new AirlineCompany();
        System.out.println("Downloading list of planes...");

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case CARGO_AIRPLANE:
                aircraftBuilder = new CargoAircraftBuilder();
                break;
            case CIVIL_AIRPLANE:
                aircraftBuilder = new CivilAircraftBuilder();
                break;
            case MILITARY_AIRPLANE:
                aircraftBuilder = new MilitaryAircraftBuilder();
                break;
            case AIRPLANE_INFO:
                break;
        }

        if (attributes.getValue("id") != null) {
            aircraftBuilder.setId(Integer.parseInt(attributes.getValue("id")));
        }
        currentTag = qName;
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String tagValue = new String(ch, start, length).trim();
        if (tagValue.length() > 0) {
            switch (currentTag) {
                case AIRPLANE_NAME:
                    aircraftBuilder.setName(tagValue);
                    break;
                case AIRPLANE_TYPE:
                    aircraftBuilder.setType(AircraftType.defineValue(tagValue));
                    break;
                case PASSANGER_AMOUNT:
                    if (tagValue != null && tagValue.trim().length() != 0) {
                        ((CivilAircraftBuilder) aircraftBuilder).setAircraftPassengerAmount(Integer.parseInt(tagValue));
                    }
                    break;
                case CAPACITY:
                    ((CargoAircraftBuilder) aircraftBuilder).setAircraftCapacity(tagValue);
                    break;
                case RANGE:
                    ((CivilAircraftBuilder) aircraftBuilder).setAircraftRange(tagValue);
                    break;
                case MAX_SPEED:
                    aircraftBuilder.setMaxSpeed(tagValue);
                    break;
                case LENGTH:
                    ((CargoAircraftBuilder) aircraftBuilder).setAircraftLength(tagValue);
                    break;
                case MILITARY_TYPE:
                    ((MilitaryAircraftBuilder) aircraftBuilder).setAircraftMilitaryType(tagValue);
                    break;
                case GUN_TYPE:
                    ((MilitaryAircraftBuilder) aircraftBuilder).setAircraftGunType(tagValue);
                    break;
            }
        }

        super.characters(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        switch (qName) {
            case CARGO_AIRPLANE:
            case CIVIL_AIRPLANE:
            case MILITARY_AIRPLANE:
                airlineCompany.addAircraft(aircraftBuilder.buildAircraft());
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("List of planes is downloaded!\n");
    }

}
