package service;

import java.util.List;

public interface FloorService {
    List<Integer> generatePassengersQuantity(int floorQuantity,
                                             int minPassengerNumber, int maxPassengerNumber);
}
