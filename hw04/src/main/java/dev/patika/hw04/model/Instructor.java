package dev.patika.hw04.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.hw04.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// implemented according to requirements
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity

@SuperBuilder

public class Instructor extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;


    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private List<Course> instructorCourse = new ArrayList<>();

    @Override
    public Course mapFromCourseDTOtoCourse(CourseDTO courseDTO) {
        return null;
    }
}