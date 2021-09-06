package dev.patika.hw04.mappers;

import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.dto.StudentDTO;
import dev.patika.hw04.model.Course;
import dev.patika.hw04.model.Student;

public interface StudentMapper {
    Student mapFromStudentDTOtoStudent(StudentDTO dto);
    StudentDTO mapFromStudenttoStudentrDTO(Student student);
}
