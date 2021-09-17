package dev.patika.hw04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.patika.hw04.dto.CourseDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Course extends AbstractBaseEntity {

    private String courseName;
    private int courseCode;
    private int creditScore;

    @JsonBackReference
    @ManyToMany(mappedBy = "studentCourse")
    @JsonIgnore
    private List<Student> courses = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;



}