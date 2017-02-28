package by.vdoroshenko.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class AirlineCompany {

 private List<Aircraft> aircraftList;

    public AirlineCompany() {
        aircraftList = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft){
     aircraftList.add(aircraft);

 }

}
