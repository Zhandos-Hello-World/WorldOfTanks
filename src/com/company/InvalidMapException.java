package com.company;

public class InvalidMapException extends Exception{
    private String message;
    public InvalidMapException(){
        message = "Not enough map.txt elements";
    }

    InvalidMapException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}