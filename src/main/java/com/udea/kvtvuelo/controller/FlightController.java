package com.udea.kvtvuelo.controller;

import com.udea.kvtvuelo.exception.FlightNotFoundException;
import com.udea.kvtvuelo.exception.InvalidRating;
import com.udea.kvtvuelo.model.Flight;
import com.udea.kvtvuelo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public Long save(@RequestBody Flight flight) throws InvalidRating {
        if (flight.getRating() > 5 ) {
            throw new InvalidRating("id shold be less than or equal 5");
        }
        return flightService.save(flight).getIdFlight();
    }

    @GetMapping("/listAll")
    public Iterable<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("/find/{id}")
    public Flight listFlightById(@PathVariable("id") Long id) {
        Optional<Flight> flight = flightService.findById(id);
        if(flight.isPresent()) {
            return flight.get() ;
        }
        throw new FlightNotFoundException("Flight no encontrado con id: " + id);
    }

    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights() {
        List<Flight> list= flightService.viewBestFlight();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.update(flight);
    }

    @DeleteMapping("{id}")
    public String deleteFlight(@PathVariable("id") long id) {
        return flightService.deleteById(id);
    }
}
