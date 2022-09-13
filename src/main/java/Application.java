import java.util.List;
import model.Building;
import service.BuildingService;
import service.ElevatorService;
import service.FloorService;
import service.PrintService;
import service.impl.BuildingServiceImpl;
import service.impl.ElevatorServiceImpl;
import service.impl.FloorServiceImpl;
import service.impl.PrintServiceImpl;

public class Application {
    private static final int MIN_FLOOR = 5;
    private static final int MAX_FLOOR = 20;
    private static final int MIN_PASSENGER_FLOOR = 0;
    private static final int MAX_PASSENGER_FLOOR = 10;
    private static final int MAX_PASSENGER_ELEVATOR = 5;
    private static final int SLEEP_NANO_SEC = 2000;
    private static int OPERATION_NUMBER = 100;

    public static void main(String[] args) {
        BuildingService buildingService = new BuildingServiceImpl();
        FloorService floorService = new FloorServiceImpl();
        int floorQuantity = buildingService.generateFloorsQuantity(MIN_FLOOR, MAX_FLOOR);

        List<Integer> passengerQuantity = floorService
                .generatePassengersQuantity(floorQuantity,
                        MIN_PASSENGER_FLOOR, MAX_PASSENGER_FLOOR);
        PrintService printService = new PrintServiceImpl(floorQuantity, MAX_PASSENGER_ELEVATOR);
        Building building = buildingService.createBuilding(floorQuantity,
                passengerQuantity, MAX_PASSENGER_ELEVATOR);
        ElevatorService elevatorService = new ElevatorServiceImpl();
        while (OPERATION_NUMBER-- > 0) {
            printService.print(building);
            elevatorService.run(building.getElevator(), building.getFloors());
            try {
                Thread.sleep(SLEEP_NANO_SEC);
            } catch (InterruptedException e) {
                throw new RuntimeException("Can`t stop program");
            }
        }
    }
}
