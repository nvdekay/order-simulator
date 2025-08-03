package com.hft.order_simulator.exception;

public class InvalidOrderStateException extends RuntimeException {
    public InvalidOrderStateException(String msg) {
        super(msg);
    }
}
