package by.vdoroshenko.builder;

import by.vdoroshenko.entity.Aircraft;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class MilitaryAircraftBuilder extends AircraftBuilder {

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

    @Override
    public Aircraft buildAircraft() {
        return new Aircraft(this);
    }
}
