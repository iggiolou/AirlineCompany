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


    //TO DO
    public void searchAircraft(String searchValue) {
        if (aircraftList.contains(searchValue)) {
            for (Aircraft aircraft : aircraftList) {
                int nameSize = aircraft.getName().length();
                if (searchValue.equalsIgnoreCase(aircraft.getName().substring(0, nameSize - 1))) {
                    System.out.println(aircraft.toString());
                }
            }
        } else {
            System.out.println("Sorry, there is no planes with name " + searchValue + " in our company");
        }
    }

}
