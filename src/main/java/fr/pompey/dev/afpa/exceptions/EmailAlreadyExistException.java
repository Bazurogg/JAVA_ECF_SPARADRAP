package fr.pompey.dev.afpa.exceptions;

/**
 * Exception thrown when an email already exists in the database.
 */
public class EmailAlreadyExistException extends Exception {

    public EmailAlreadyExistException(String message) {

        super(message);

    }

}