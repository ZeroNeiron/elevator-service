package service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import model.Elevator;
import model.Floor;
import model.Passenger;
import service.ElevatorService;
import util.PassengerGenerator;

public class ElevatorServiceImpl implements ElevatorService {
    @Override
    public void run(Elevator elevator, List<Floor> floors) {
        Floor currentFloor = floors.get(elevator.getCurrentFloor());
        sortPassengers(currentFloor);
        int floorsQuantity = floors.size();
        elevator.setUp(checkToChangeDirection(currentFloor, elevator, floorsQuantity));
        transferPassengers(elevator, currentFloor, floorsQuantity);
        elevator.setMaxFloor(getMaxFloor(elevator));
        elevator.setCurrentFloor(currentFloor.getNumber() + (elevator.isUp() ? 1 : -1));
    }

    private boolean hasPlaces(Elevator elevator) {
        return elevator.getPassengersInside().size() < elevator.getMaxCapacity();
    }

    private void sortPassengers(Floor floor) {
        floor.getPassengers().sort(Comparator.comparing(
                Passenger::getRequiredFloor));
    }

    private void transferPassengers(Elevator elevator, Floor floor, int floorsQuantity) {
        List<Passenger> deletedPassenger = new ArrayList<>();
        List<Passenger> passengers = elevator.getPassengersInside();
        passengers.stream()
                .filter(passenger -> passenger.getRequiredFloor() == floor.getNumber())
                .forEach(passenger -> {
                    deletedPassenger.add(passenger);
                    passenger.setCurrentFloor(floor.getNumber());
                    PassengerGenerator.generateRandomRequiredFloor(passenger, floorsQuantity);
                });
        passengers.removeAll(deletedPassenger);
        addPassengerFromFloor(elevator, floor);
        floor.getPassengers().addAll(deletedPassenger);
    }

    private void addPassengerFromFloor(Elevator elevator, Floor floor) {
        List<Passenger> passengers = floor.getPassengers();
        while (hasPlaces(elevator) && passengers.size() > 0) {
            Passenger passenger = passengers.get(0);
            if (elevator.isUp()) {
                passenger = passengers.get(passengers.size() - 1);
                if (passenger.getRequiredFloor() < floor.getNumber()) {
                    break;
                }
            }
            if (!elevator.isUp() && passenger.getRequiredFloor() > floor.getNumber()) {
                break;
            }
            elevator.getPassengersInside().add(passenger);
            passengers.remove(passenger);
        }
    }

    private int getMaxFloor(Elevator elevator) {
        IntStream intStream = elevator.getPassengersInside().stream()
                .mapToInt(Passenger::getRequiredFloor);
        return elevator.isUp() ? intStream.max().orElse(100) : intStream.min().orElse(0);
    }

    private boolean checkToChangeDirection(Floor floor, Elevator elevator, int floorsQuantity) {
        long upCount = floor.getPassengers().stream()
                .filter(passenger -> passenger.getRequiredFloor() > floor.getNumber())
                .count();
        long downCount = floor.getPassengers().size() - upCount;
        if (elevator.getCurrentFloor() + 1 == floorsQuantity) {
            return false;
        }
        if (elevator.getCurrentFloor() == 0 && !elevator.isUp()) {
            return true;
        }
        if (elevator.getPassengersInside().size() == 0) {
            if (upCount == downCount) {
                return false;
            }
            return upCount > downCount;
        }
        return elevator.isUp();
    }
}
