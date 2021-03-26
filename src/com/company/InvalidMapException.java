package com.company;

public class InvalidMapException extends Exception{
    private String message;
    InvalidMapException(){
        message = "Not enough map elements";
    }

    InvalidMapException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}