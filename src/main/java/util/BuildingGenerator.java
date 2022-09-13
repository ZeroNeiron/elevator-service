package util;

import model.Building;
import model.Floor;

public class BuildingGenerator {
    public static void generateFloorsForBuilding(Building building, int floorsNumber) {
        for (int i = 0; i < floorsNumber; i++) {
            building.getFloors().add(new Floor(i));
        }
    }
}
