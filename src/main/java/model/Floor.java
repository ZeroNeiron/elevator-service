package model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Passenger> passengers;
    private Integer number;
    private Floor next;
    private Floor previous;

    public Floor(Integer number) {
        this.number = number;
        passengers = new ArrayList<>();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Floor getNext() {
        return next;
    }

    public void setNext(Floor next) {
        this.next = next;
    }

    public Floor getPrevious() {
        return previous;
    }

    public void setPrevious(Floor previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Passenger passenger : passengers) {
            stringBuilder.append(passenger.getRequiredFloor() + 1).append(" ");
        }
        return stringBuilder.toString();
    }
}
