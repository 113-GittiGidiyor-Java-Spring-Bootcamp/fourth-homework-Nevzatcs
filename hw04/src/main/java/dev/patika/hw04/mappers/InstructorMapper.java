package dev.patika.hw04.mappers;

import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.dto.InstructorDTO;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InstructorMapper {
    public abstract Instructor mapFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);
    public abstract InstructorDTO mapFromInstructortoInstructorDTO(Instructor instructor);
}
