package by.vdoroshenko.entity;

import java.util.*;

/**
 * Created by viktoriyadoroshenko on 2/27/17.
 */
public class AirlineCompany {

    private List<Aircraft> aircraftList;

    public AirlineCompany() {
        aircraftList = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    public void showAircraftList() {

        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.toString());
        }

    }

    public void showSortedAircraftList() {
        Collections.sort(aircraftList, new Comparator<Aircraft>() {
            @Override
            public int compare(Aircraft aircraft1, Aircraft aircraft2) {
                return aircraft1.getName().compareTo(aircraft2.getName());
            }
        });
        for (Aircraft aircraft : aircraftList) {
            System.out.println(aircraft.toString());
        }
    }

    public void searchAircraft(String searchValue) {
        for (Aircraft aircraft : aircraftList) {
            if (searchValue.equalsIgnoreCase(aircraft.getName().toLowerCase())) {
                System.out.println(aircraft.toString());
            }
        }
    }

}
