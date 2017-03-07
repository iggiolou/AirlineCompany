package by.vdoroshenko.entity;

import by.vdoroshenko.builder.AircraftBuilder;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class Aircraft {

    private int id;
    private String name;
    private AircraftType type;
    private String maxSpeed;

    public Aircraft(AircraftBuilder aircraftBuilder) {
        this.setId(aircraftBuilder.getId());
        this.setName(aircraftBuilder.getName());
        this.setType(aircraftBuilder.getType());
        this.setMaxSpeed(aircraftBuilder.getMaxSpeed());
    }

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

    @Override
    public String toString() {
        StringBuilder aircraftStringBuilder = new StringBuilder();
        aircraftStringBuilder.append("Airplane Name: " + getName());
        aircraftStringBuilder.append("\n");
        aircraftStringBuilder.append("Airplane Type: " + getType());
        aircraftStringBuilder.append("\n");
        return aircraftStringBuilder.toString();
    }

}
