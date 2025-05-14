package com.udea.kvtvuelo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "flight")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idFlight;

    @NonNull
    @Column(name = "nombreAvion", nullable = false, length = 80)
    private String nombreAvion;

    @NonNull
    @Column(name = "numVuelo", nullable = false, length = 80)
    private String numVuelo;

    @NonNull
    @Column(name = "origen", nullable = false, length = 80)
    private String origen;

    @NonNull
    @Column(name = "destino", nullable = false, length = 80)
    private String destino;

    @NonNull
    @Column(name = "capacidad", nullable = false, length = 80)
    private int capacidad;

    @NonNull
    @Column(name = "rating", nullable = false, length = 80)
    @Min(value = 1, message = "id should be more or than equal 1")
    @Max(value = 5, message = "id should be less or than equal 15")
    private int rating;

    @NonNull
    @Column(name = "planVuelo", nullable = false, length = 80)
    private String planVuelo;

    @Column(name = "cumplido")
    private boolean cumplido;

    public Long getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Long idFlight) {
        this.idFlight = idFlight;
    }

    public @NonNull String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(@NonNull String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public @NonNull String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(@NonNull String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public @NonNull String getOrigen() {
        return origen;
    }

    public void setOrigen(@NonNull String origen) {
        this.origen = origen;
    }

    public @NonNull String getDestino() {
        return destino;
    }

    public void setDestino(@NonNull String destino) {
        this.destino = destino;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public @NonNull String getPlanVuelo() {
        return planVuelo;
    }

    public void setPlanVuelo(@NonNull String planVuelo) {
        this.planVuelo = planVuelo;
    }

    public boolean getCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }
}
