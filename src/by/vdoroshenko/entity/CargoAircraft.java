package by.vdoroshenko.entity;

import by.vdoroshenko.builder.AircraftBuilder;

/**
 * Created by viktoriyadoroshenko on 2/28/17.
 */
public class CargoAircraft extends Aircraft {

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

    public CargoAircraft(AircraftBuilder aircraftBuilder) {
        super(aircraftBuilder);
        this.setAircraftCapacity(getAircraftCapacity());
        this.setAircraftLength(getAircraftLength());

    }
}
