package service.impl;

import model.Building;
import service.PrintService;

public class PrintServiceImpl implements PrintService {
    public static final int SEPARATOR_LENGTH = 3;
    private final int floorQuantity;
    private final int passengerQuantityInElevator;

    public PrintServiceImpl(int floorQuantity,
                            int passengerQuantityInElevator) {
        this.floorQuantity = floorQuantity;
        this.passengerQuantityInElevator = passengerQuantityInElevator;
    }

    @Override
    public void print(Building building) {
        StringBuilder stringBuilder = new StringBuilder(System.lineSeparator());
        String elevatorSeparator = "|";
        for (int i = floorQuantity - 1; i >= 0; i--) {
            stringBuilder.append(PrintService
                    .addSpacesToRequiredLength(String.valueOf(i + 1), SEPARATOR_LENGTH))
                    .append(elevatorSeparator);
            if (i == building.getElevator().getCurrentFloor()) {
                stringBuilder.append(building.getElevator());
            } else {
                stringBuilder.append(PrintService
                        .addSpacesToRequiredLength(" ",
                                SEPARATOR_LENGTH * (passengerQuantityInElevator + 2)));
            }
            stringBuilder.append(elevatorSeparator)
                    .append(building.getFloors().get(i))
                    .append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }
}
