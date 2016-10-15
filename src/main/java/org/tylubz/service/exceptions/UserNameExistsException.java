package org.tylubz.service.exceptions;

/**
 * Created by Sergei on 14.10.2016.
 */
public class UserNameExistsException extends Exception{

    public UserNameExistsException() {
        super();
    }

    public UserNameExistsException(String message) {
        super(message);
    }

    public UserNameExistsException(Throwable cause) {
        super(cause);
    }

    public UserNameExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
