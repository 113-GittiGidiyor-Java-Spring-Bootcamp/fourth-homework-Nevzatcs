package dev.patika.hw04.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// implemented according to requirements
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student  extends AbstractBaseEntity{

    private String s_name;
    private LocalDate s_birthDate;
    private String s_address;
    private String s_gender;

    @ManyToMany
    private List<Course> studentCourse = new ArrayList<>();



}