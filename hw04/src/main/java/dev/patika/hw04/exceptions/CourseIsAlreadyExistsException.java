package dev.patika.hw04.exceptions;

public class CourseIsAlreadyExistsException extends RuntimeException {
    public CourseIsAlreadyExistsException(String msg){
        super(msg);
    }
}

