package com.juliomesquita.ecommerce.infra.exceptions.custom;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("Registro não encontrado.");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
