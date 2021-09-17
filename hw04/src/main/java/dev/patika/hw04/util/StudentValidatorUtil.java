package dev.patika.hw04.util;

import dev.patika.hw04.exceptions.StudentAgeNotValidException;

import java.time.LocalDate;
import java.time.Period;

public class StudentValidatorUtil {
    public static void validateStudentAge(LocalDate bDate) {
        int studentAge= Period.between(bDate,LocalDate.now()).getYears();
        if(studentAge<18 || studentAge>40){
            throw new StudentAgeNotValidException(ErrorMessageConstants.STUDENT_AGE);
        }
    }
}
