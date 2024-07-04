package com.juliomesquita.ecommerce.infra.exceptions.custom;

public class CommunicationBetweenServicesException extends RuntimeException{
    public CommunicationBetweenServicesException() {
        super("Erro na comunicação entre micro serviços.");
    }

    public CommunicationBetweenServicesException(String message) {
        super(message);
    }
}
