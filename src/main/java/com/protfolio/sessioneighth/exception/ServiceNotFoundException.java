package com.protfolio.sessioneighth.exception;

import lombok.Getter;

public class ServiceNotFoundException extends RuntimeException{

    @Getter
    private String message;

    public ServiceNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
