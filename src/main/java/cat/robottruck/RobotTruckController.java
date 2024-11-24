package cat.robottruck;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")

public class RobotTruckController {
    private final RobotTruckService robotTruckService;

    public RobotTruckController(RobotTruckService robotTruckService) {
        this.robotTruckService = robotTruckService;
    }

    @PostMapping("/place")
    public ResponseEntity<String> place(@RequestParam int x, @RequestParam int y, @RequestParam String direction) {
        return ResponseEntity.ok(robotTruckService.place(x, y, direction));
    }

    @PostMapping("/move")
    public ResponseEntity<String> move() {
        return ResponseEntity.ok(robotTruckService.move());
    }

    @PostMapping("/left")
    public ResponseEntity<String> left() {
        return ResponseEntity.ok(robotTruckService.turnLeft());
    }

    @PostMapping("/right")
    public ResponseEntity<String> right() {
        return ResponseEntity.ok(robotTruckService.turnRight());
    }

    @GetMapping("/report")
    public ResponseEntity<String> report() {
        return ResponseEntity.ok(robotTruckService.report());
    }
}
