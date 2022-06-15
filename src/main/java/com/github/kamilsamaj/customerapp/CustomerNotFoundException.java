package com.github.kamilsamaj.customerapp;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id) {
        super(String.format("Customer with id %s not found", id));
    }
}
