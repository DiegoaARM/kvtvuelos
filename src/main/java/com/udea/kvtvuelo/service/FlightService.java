package com.udea.kvtvuelo.service;

import com.udea.kvtvuelo.dao.IFlightDAO;
import com.udea.kvtvuelo.exception.FlightNotFoundException;
import com.udea.kvtvuelo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private IFlightDAO dao;

    public Flight save(Flight flight) {
        return dao.save(flight);
    }

    public String deleteById(Long id) {
        dao.deleteById(id);
        return "Flight deleted";
    }

    public Iterable<Flight> findAll() {
        return dao.findAll();
    }

    public Optional<Flight> findById(Long id) {
        return dao.findById(id);
    }

    public Flight update (Flight flight) {
        Flight existingFlight = dao.findById(flight.getIdFlight()).orElse(null);

        existingFlight.setNombreAvion(flight.getNombreAvion());
        existingFlight.setNumVuelo(flight.getNumVuelo());
        existingFlight.setOrigen(flight.getOrigen());
        existingFlight.setDestino(flight.getDestino());
        existingFlight.setRating(flight.getRating());
        existingFlight.setPlanVuelo(flight.getPlanVuelo());
        existingFlight.setCapacidad(flight.getCapacidad());
        existingFlight.setCumplido(flight.getCumplido());

        return dao.save(existingFlight);
    }

    public List<Flight> viewBestFlight() throws FlightNotFoundException {
        List<Flight> flights = dao.viewBestFlight();

        if (!flights.isEmpty()) {
            return flights;
        } else {
            throw new FlightNotFoundException("No flight found with rating > 4");
        }
    }
}
