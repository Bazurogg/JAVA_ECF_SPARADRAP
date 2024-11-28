package fr.pompey.dev.afpa.exceptions;

/**
 * Exception thrown when a required field is empty.
 */
public class EmptyFieldException extends Exception {

    public EmptyFieldException(String message) {

        super(message);

    }

}
