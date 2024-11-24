package cat.robottruck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The robot truck service is a management layer for all trucks.
 * In the initial implementation there is just a single truck but this class is the entry point into all operations involving any number of trucks.
 * To support multiple trucks replace the Single truck with a RobotTruckRepository that manages many trucks within the system.
 * Individual trucks would have a unique external key that is in addition to any internal only primary keys. The external key is provided
 * to clients with the primary key never exposed.
 */
@Service
public class RobotTruckService {
    private static final Logger logger = LoggerFactory.getLogger(RobotTruckService.class);
    private RobotTruck robotTruck;

    public String place(int x, int y, String direction) {
        robotTruck = new RobotTruck();
        boolean isValidPlacement = robotTruck.place(x, y, direction);
        if (!isValidPlacement) {
            logger.error("Truck was placed outside the available area");
        }
        return report();
    }

    public String move() {
        robotTruck.move();
        return report();
    }

    public String turnLeft() {
        robotTruck.turnLeft();
        return report();
    }

    public String turnRight() {
        robotTruck.turnRight();
        return report();
    }

    public String report() {
        if (robotTruck == null) {
            return "ROBOT MISSING";
        }
        return robotTruck.report();
    }
}
