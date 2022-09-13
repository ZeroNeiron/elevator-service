package model;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private Elevator elevator;
    private List<Floor> floors;

    public Building() {
        floors = new ArrayList<>();
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
