package model;

import java.util.ArrayList;
import java.util.List;
import service.PrintService;

public class Elevator {
    private int maxCapacity;
    private List<Passenger> passengersInside;
    private boolean up;
    private int currentFloor;
    private int maxFloor;

    public Elevator(int maxCapacity, int maxFloor) {
        passengersInside = new ArrayList<>(maxCapacity);
        up = true;
        this.maxCapacity = maxCapacity;
        this.maxFloor = maxFloor;
    }

    public int getMaxCapacity() {

        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {

        this.maxCapacity = maxCapacity;
    }

    public List<Passenger> getPassengersInside() {

        return passengersInside;
    }

    public void setPassengersInside(List<Passenger> passengersInside) {

        this.passengersInside = passengersInside;
    }

    public Boolean isUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String direction = isUp() ? "^" : "v";
        stringBuilder.append(direction);
        for (int i = 0; i < maxCapacity; i++) {
            String requiredFloor = " ";
            if (i < passengersInside.size()) {
                requiredFloor = String.valueOf(passengersInside.get(i).getRequiredFloor() + 1);
            }
            stringBuilder.append(PrintService
                    .addSpacesToRequiredLength(requiredFloor, PrintService.SEPARATOR_LENGTH));
        }
        return stringBuilder.append(direction).toString();
    }
}
