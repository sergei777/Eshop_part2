package org.tylubz.service.exceptions;

/**
 * Created by Sergei on 14.10.2016.
 */
public class EmailExistsException extends Exception {

    public EmailExistsException() {
        super();
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(Throwable cause) {
        super(cause);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
