package by.vdoroshenko.builder;

import by.vdoroshenko.entity.Aircraft;
import by.vdoroshenko.entity.AircraftType;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class AircraftBuilder {

    private int id;
    private String name;
    private AircraftType type;
    private String maxSpeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AircraftType getType() {
        return type;
    }

    public void setType(AircraftType type) {
        this.type = type;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Aircraft buildAircraft() {
        return new Aircraft(this);
    }
}

