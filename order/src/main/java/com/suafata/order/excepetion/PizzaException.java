package com.suafata.order.excepetion;

public class PizzaException extends RuntimeException {

    public PizzaException(String message) {super(message);}

    public PizzaException(String message, Throwable throwable) {super(message, throwable);}
}
