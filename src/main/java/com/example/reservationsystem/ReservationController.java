package com.example.reservationsystem;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class ReservationController {

    private static final Logger log = Logger.getLogger(String.valueOf(ReservationController.class));

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        log.info("CALLED getReservationById: id=" + id);
        return reservationService.getReservationById(id);
    }

    @GetMapping()
    public List<Reservation> getAllReservation() {
        log.info("CALLED getAllReservation");
        return reservationService.findAllReservation();
    }

}
