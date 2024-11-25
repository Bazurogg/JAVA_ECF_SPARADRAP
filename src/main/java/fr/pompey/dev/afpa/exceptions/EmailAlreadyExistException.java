0package fr.pompey.dev.afpa.exceptions;

/**
 * Exception thrown when an email already exists in the system.
 */
public class EmailAlreadyExistException extends Exception {

    public EmailAlreadyExistException(String message) {

        super(message);

    }

}