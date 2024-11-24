package cat.robottruck;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")

public class RobotTruckController {
    private static final Logger logger = LoggerFactory.getLogger(RobotTruckController.class);
    private final RobotTruckService robotTruckService;

    public RobotTruckController(RobotTruckService robotTruckService) {
        this.robotTruckService = robotTruckService;
    }

    @PostMapping("/place")
    public ResponseEntity<String> place(@RequestParam int x, @RequestParam int y, @RequestParam String direction) {
        logger.info("Place x:{},y:{},{}", x, y, direction);
        return ResponseEntity.ok(robotTruckService.place(x, y, direction));
    }

    @PutMapping("/move")
    public ResponseEntity<String> move() {
        logger.info("Move");
        return ResponseEntity.ok(robotTruckService.move());
    }

    @PutMapping("/left")
    public ResponseEntity<String> left() {
        logger.info("Left");
        return ResponseEntity.ok(robotTruckService.turnLeft());
    }

    @PutMapping("/right")
    public ResponseEntity<String> right() {
        logger.info("Right");
        return ResponseEntity.ok(robotTruckService.turnRight());
    }

    @GetMapping("/report")
    public ResponseEntity<String> report() {
        logger.info("Report");
        return ResponseEntity.ok(robotTruckService.report());
    }
}
