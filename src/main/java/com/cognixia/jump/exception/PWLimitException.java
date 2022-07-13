package com.cognixia.jump.exception;

import java.lang.Exception;

public class PWLimitException extends Exception {
    public PWLimitException() {
        super("Password length is too small.");
    }

    public boolean printMessage(String password) {
        if (!(password.length() >= 4)) {
            System.out.println("Password length should be at least 4 characters");
            return false;
        } else {
            return true;
        }
    }
}
