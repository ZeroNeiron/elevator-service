package service;

import java.util.List;
import model.Building;

public interface BuildingService {
    Building createBuilding(int floorQuantity, List<Integer> passengerOnFloorQuantity,
                            int passengersInElevatorQuantity);

    int generateFloorsQuantity(int minFloorNumber, int maxFloorNumber);
}
