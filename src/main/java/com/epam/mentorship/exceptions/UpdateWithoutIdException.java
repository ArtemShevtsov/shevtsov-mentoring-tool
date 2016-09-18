package com.epam.mentorship.exceptions;

/**
 * Created by aftor on 18.09.16.
 */
public class UpdateWithoutIdException extends Exception {
    public UpdateWithoutIdException(Class claz) {
        super("Trying to update " + claz.getCanonicalName() + " without ID.");
    }
}
