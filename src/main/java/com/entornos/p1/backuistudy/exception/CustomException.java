package com.entornos.p1.backuistudy.exception;

import java.util.Arrays;

public class CustomException extends RuntimeException {

    public CustomException(String aMensaje) {
        super(aMensaje);
        this.setStackTrace(Arrays.copyOf(this.getStackTrace(), 1));
    }

}
