package dev.patika.hw04.model;

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
@Builder
@ToString
public class Course extends AbstractBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int courseCode;
    private int creditScore;


    @JsonManagedReference
    @ManyToMany(mappedBy = "studentCourse")
    @JsonIgnore
    private List<Student> courses = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;


}