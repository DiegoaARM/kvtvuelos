package com.udea.kvtvuelo.dao;

import com.udea.kvtvuelo.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.http.HttpHeaders.FROM;

@Repository
public interface IFlightDAO extends CrudRepository<Flight, Long> {

    @Query("FROM Flight f WHERE f.rating >= 4 AND f.cumplido = true")
    public List<Flight> viewBestFlight();
}
