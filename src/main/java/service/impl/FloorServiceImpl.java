package service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import service.FloorService;

public class FloorServiceImpl implements FloorService {
    @Override
    public List<Integer> generatePassengersQuantity(int floorQuantity,
                                                    int minPassengerNumber,
                                                    int maxPassengerNumber) {
        Random random = new Random();
        return random
                .ints(floorQuantity, minPassengerNumber, (maxPassengerNumber + 1))
                .boxed()
                .collect(Collectors.toList());
    }
}
