package com.example.reservationsystem;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private static final Logger log = Logger.getLogger(String.valueOf(ReservationController.class));

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        log.info("CALLED getReservationById: id=" + id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationService.getReservationById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> getAllReservation() {
        log.info("CALLED getAllReservation");
        return ResponseEntity.ok(reservationService.findAllReservation());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservationToCreate) {
        log.info("CALLED reservationToCreate");

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("test-header", "123")
                .body(reservationService.createReservation(reservationToCreate));
    }

}
