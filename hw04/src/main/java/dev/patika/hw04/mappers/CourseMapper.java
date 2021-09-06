package dev.patika.hw04.mappers;

import dev.patika.hw04.dto.CourseDTO;
import dev.patika.hw04.model.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    public abstract Course mapFromCourseDTOtoCourse(CourseDTO dto);
    CourseDTO mapFromCoursetoCourseDTO(Course course);
}
