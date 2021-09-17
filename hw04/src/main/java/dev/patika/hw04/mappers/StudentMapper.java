package dev.patika.hw04.mappers;


import dev.patika.hw04.dto.StudentDTO;

import dev.patika.hw04.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    public abstract Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);
    public abstract StudentDTO mapFromStudenttoStudentrDTO(Student student);
}
