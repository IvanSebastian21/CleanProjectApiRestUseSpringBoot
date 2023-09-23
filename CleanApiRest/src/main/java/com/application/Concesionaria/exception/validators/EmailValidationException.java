package com.application.Concesionaria.exception.validators;

public class EmailValidationException extends RuntimeException{

    public EmailValidationException(){
        super("El mail no posee el formato requerido.");
    }
}
