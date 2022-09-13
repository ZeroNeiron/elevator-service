package service;

import java.util.List;
import model.Elevator;
import model.Floor;

public interface ElevatorService {
    void run(Elevator elevator, List<Floor> floors);
}
