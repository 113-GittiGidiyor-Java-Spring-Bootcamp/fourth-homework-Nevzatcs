package dev.patika.hw04.exceptions;

public class StudentAgeNotValidException extends  RuntimeException{
    public StudentAgeNotValidException(String msg){
        super(msg);
    }
}
