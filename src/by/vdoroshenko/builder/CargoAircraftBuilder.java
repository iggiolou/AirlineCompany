package by.vdoroshenko.builder;

import by.vdoroshenko.entity.Aircraft;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class CargoAircraftBuilder extends AircraftBuilder {

    private String aircraftCapacity;
    private String aircraftLength;

    public String getAircraftCapacity() {
        return aircraftCapacity;
    }

    public void setAircraftCapacity(String aircraftCapacity) {
        this.aircraftCapacity = aircraftCapacity;
    }

    public String getAircraftLength() {
        return aircraftLength;
    }

    public void setAircraftLength(String aircraftLength) {
        this.aircraftLength = aircraftLength;
    }

    @Override
    public Aircraft buildAircraft() {
        return new Aircraft(this);
    }
}
