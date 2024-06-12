package com.mycompany.crud_estudiantes01.jpa.exceptions;

public class NonexistentEntityException extends Exception {
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NonexistentEntityException(String message) {
        super(message);
    }
}
