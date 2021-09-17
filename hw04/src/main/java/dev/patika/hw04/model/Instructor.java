package dev.patika.hw04.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

public class Instructor extends AbstractBaseEntity{

    private String name;
    private String address;
    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "instructor")
    @JsonIgnore
    private List<Course> instructorCourse = new ArrayList<>();


}