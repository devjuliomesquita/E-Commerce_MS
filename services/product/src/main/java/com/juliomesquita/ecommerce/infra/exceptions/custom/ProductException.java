package com.juliomesquita.ecommerce.infra.exceptions.custom;

public class ProductException extends RuntimeException{
    public ProductException() {
        super("Produto com erro.");
    }

    public ProductException(String message) {
        super(message);
    }
}
