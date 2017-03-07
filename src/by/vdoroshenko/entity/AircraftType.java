package by.vdoroshenko.entity;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public enum AircraftType {

    CIVIL("Civil"),
    MILITARY("Military"),
    CARGO("Cargo");

    private String value;

    AircraftType(String value) {
        this.value = value;

    }

    public static AircraftType defineValue(String value) {
        for (AircraftType aircraftType : AircraftType.values()) {
            if (aircraftType.value.equals(value)) {
                return aircraftType;
            }
        }
        return null;
    }

}

