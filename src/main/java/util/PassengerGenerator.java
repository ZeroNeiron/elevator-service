package util;

import java.util.Random;
import model.Passenger;

public class PassengerGenerator {
    public static void generateRandomRequiredFloor(Passenger passenger, int maxFloorsNumber) {
        Random random = new Random();
        Integer requiredFloor = random
                .ints(0, maxFloorsNumber)
                .filter(n -> n != passenger.getCurrentFloor())
                .findFirst()
                .getAsInt();
        passenger.setRequiredFloor(requiredFloor);
    }
}
