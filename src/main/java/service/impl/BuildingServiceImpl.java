package service.impl;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import model.Building;
import model.Elevator;
import model.Floor;
import service.BuildingService;
import util.BuildingGenerator;
import util.FloorGenerator;
import util.PassengerGenerator;

public class BuildingServiceImpl implements BuildingService {
    @Override
    public Building createBuilding(int floorQuantity,
                                   List<Integer> passengerOnFloorQuantity,
                                   int passengersInElevatorQuantity) {
        Building building = new Building();
        addFloorsForBuilding(building, floorQuantity);
        addPassengerForFloat(building, passengerOnFloorQuantity);
        addRequiredFloors(building, floorQuantity);
        Elevator elevator = new Elevator(passengersInElevatorQuantity, floorQuantity);
        building.setElevator(elevator);
        return building;
    }

    @Override
    public int generateFloorsQuantity(int minFloorNumber, int maxFloorNumber) {
        Random random = new Random();
        return minFloorNumber + random.nextInt(maxFloorNumber - minFloorNumber + 1);
    }

    private void addRequiredFloors(Building building, int floorQuantity) {
        building.getFloors()
                .stream()
                .map(Floor::getPassengers).forEach(passengers -> passengers
                .forEach(p -> PassengerGenerator.generateRandomRequiredFloor(p, floorQuantity)));
    }

    private void addPassengerForFloat(Building building, List<Integer> passengerOnFloorQuantity) {
        AtomicInteger i = new AtomicInteger();
        building.getFloors().forEach(f -> FloorGenerator
                .generatePassengersForFloor(f, passengerOnFloorQuantity.get(i.getAndIncrement())));
    }

    private void addFloorsForBuilding(Building building, int floorQuantity) {
        BuildingGenerator.generateFloorsForBuilding(building, floorQuantity);
    }
}
