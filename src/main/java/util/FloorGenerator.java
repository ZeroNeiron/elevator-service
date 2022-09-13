package util;

import model.Floor;
import model.Passenger;

public class FloorGenerator {
    public static void generatePassengersForFloor(Floor floor, int passengerNumber) {
        for (int i = 0; i < passengerNumber; i++) {
            floor.getPassengers().add(new Passenger(floor.getNumber()));
        }
    }
}
