package model;

public class Passenger {
    private int currentFloor;
    private int requiredFloor;

    public Passenger(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getRequiredFloor() {
        return requiredFloor;
    }

    public void setRequiredFloor(int requiredFloor) {
        this.requiredFloor = requiredFloor;
    }
}
