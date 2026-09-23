package com.pragma.powerup.domain.exception;

public class InvalidCellphoneException extends DomainException{
    public InvalidCellphoneException() {
        super("El numero de celular es invalido o incorrecto");
    }
}
