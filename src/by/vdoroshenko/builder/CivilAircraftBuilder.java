package by.vdoroshenko.builder;

import by.vdoroshenko.entity.Aircraft;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class CivilAircraftBuilder extends AircraftBuilder {

    private int aircraftPassengerAmount;
    private String aircraftRange;

    public int getAircraftPassengerAmount() {
        return aircraftPassengerAmount;
    }

    public void setAircraftPassengerAmount(int aircraftPassengerAmount) {
        this.aircraftPassengerAmount = aircraftPassengerAmount;
    }

    public String getAircraftRange() {
        return aircraftRange;
    }

    public void setAircraftRange(String aircraftRange) {
        this.aircraftRange = aircraftRange;
    }

    @Override
    public Aircraft buildAircraft() {
        return new Aircraft(this);

    }
}
