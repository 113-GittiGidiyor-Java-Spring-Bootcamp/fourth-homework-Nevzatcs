package dev.patika.hw04.mappers;

import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.dto.InstructorDTO;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Instructor;

public interface InstructorMapper {
    Instructor mapFromInstructorDTOtoInstructor(InstructorDTO dto);
    InstructorDTO mapFromInstructortoInstructorDTO(Instructor instructor);
}
