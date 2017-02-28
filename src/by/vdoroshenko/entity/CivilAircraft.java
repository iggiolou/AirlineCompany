package by.vdoroshenko.entity;

import by.vdoroshenko.builder.CivilAircraftBuilder;

/**
 * Created by viktoriyadoroshenko on 2/28/17.
 */
public class CivilAircraft extends Aircraft {

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

    public CivilAircraft(CivilAircraftBuilder aircraftBuilder) {
        super(aircraftBuilder);
        this.setAircraftPassengerAmount(getAircraftPassengerAmount());
        this.setAircraftRange(getAircraftRange());
    }
}
