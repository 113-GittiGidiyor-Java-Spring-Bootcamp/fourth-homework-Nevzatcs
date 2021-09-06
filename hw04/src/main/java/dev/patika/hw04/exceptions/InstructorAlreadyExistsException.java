package dev.patika.hw04.exceptions;

public class InstructorAlreadyExistsException  extends RuntimeException {
    public InstructorAlreadyExistsException(String msg){
        super(msg);
    }

}