package by.vdoroshenko.entity;

import by.vdoroshenko.builder.AircraftBuilder;

/**
 * Created by viktoriyadoroshenko on 2/28/17.
 */
public class MilitaryAircraft extends Aircraft {

    private String aircraftMilitaryType;
    private String aircraftGunType;

    public String getAircraftMilitaryType() {
        return aircraftMilitaryType;
    }

    public void setAircraftMilitaryType(String aircraftMilitaryType) {
        this.aircraftMilitaryType = aircraftMilitaryType;
    }

    public String getAircraftGunType() {
        return aircraftGunType;
    }

    public void setAircraftGunType(String aircraftGunType) {
        this.aircraftGunType = aircraftGunType;
    }

    public MilitaryAircraft(AircraftBuilder aircraftBuilder) {
        super(aircraftBuilder);
        this.setAircraftGunType(getAircraftGunType());
        this.setAircraftMilitaryType(getAircraftMilitaryType());
    }
}
