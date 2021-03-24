package com.company;

public class InvalidMapException extends Exception{
    private String message;
    InvalidMapException(String message){
        this.message = message;
    }
    InvalidMapException(){
        message = "Not enough map elements";
    }
    @Override
    public String getMessage() {
        return message;
    }
}