package com.udea.kvtvuelo.exception;

public class InvalidRating extends RuntimeException {

    public InvalidRating(String message) {
        super(message);
    }

    public InvalidRating() {
        super();
    }
}
