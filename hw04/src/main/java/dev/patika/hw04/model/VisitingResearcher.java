package dev.patika.hw04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

// implemented according to requirements
@Data
@AllArgsConstructor
@NoArgsConstructor

public class VisitingResearcher extends Instructor{

    private double hourlySalary;


}